package org.deripas.chrome.protocol.builder;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.CaseFormat;
import com.google.common.base.Preconditions;
import com.palantir.javapoet.*;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.deripas.chrome.protocol.Protocol;

import javax.annotation.Nullable;
import javax.lang.model.element.Modifier;
import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkState;

@Slf4j
@UtilityClass
public class DataTypeBuilder {

    @Builder
    public static TypeSpec.Builder build(
        String typeName,
        List<Protocol.DomainParameter> parameters,
        TypeNameResolver typeNameResolver
    ) {
        Preconditions.checkNotNull(parameters);
        final TypeSpec.Builder builder = TypeSpec.classBuilder(typeName)
            .addModifiers(Modifier.PUBLIC)
            .addAnnotation(Data.class)
            .addAnnotation(AnnotationSpec.builder(Builder.class)
                .addMember("toBuilder", "$L", "true")
                .build());

        for (Protocol.DomainParameter parameter : parameters) {
            final TypeName type = resolveType(parameter, builder, typeNameResolver);
            log.debug("[{}] Adding field: {} type {}", typeName, parameter.name(), type);
            final FieldSpec.Builder fieldBuilder;
            if (isThis(parameter.name())) {
                log.warn("Field name {} is a keyword", parameter.name());
                fieldBuilder = FieldSpec.builder(type, "thisRef")
                    .addAnnotation(
                        AnnotationSpec.builder(JsonProperty.class)
                            .addMember("value", "$S", parameter.name())
                            .build()
                    );
            } else {
                fieldBuilder = FieldSpec.builder(type, parameter.name());
            }

            fieldBuilder.addModifiers(Modifier.PRIVATE, Modifier.FINAL);

            if (StringUtils.isNotEmpty(parameter.description())) {
                fieldBuilder.addJavadoc(parameter.description());
            }
            if (parameter.optional()) {
                fieldBuilder.addAnnotation(Nullable.class);
            }
            if (parameter.experimental()) {
                fieldBuilder.addAnnotation(Experimental.class);
            }
            if (parameter.deprecated()) {
                fieldBuilder.addAnnotation(Deprecated.class);
            }
            builder.addField(fieldBuilder.build());
        }
        return builder;
    }

    private static TypeName resolveType(
        Protocol.DomainParameter parameter,
        TypeSpec.Builder builder,
        TypeNameResolver typeNameResolver
    ) {
        if (isRefType(parameter)) {
            return typeNameResolver.resolve(parameter.ref());
        }
        if (isArrayType(parameter)) {
            checkState("array" .equals(parameter.type()));
            final TypeName itemType = typeNameResolver.resolveArrayItemType(parameter.items());
            return ParameterizedTypeName.get(ClassName.get(List.class), itemType);
        }
        if (isEnumType(parameter)) {
            final String enumTypeName = normalizeEnumTypeName(parameter.name());
            final TypeSpec.Builder buildEnum = EnumTypeBuilder.builder()
                .typeName(enumTypeName)
                .enumerate(parameter.enumerate())
                .build();
            builder.addType(buildEnum.build());
            return ClassName.bestGuess(enumTypeName);
        }
        checkState(parameter.type() != null);
        if (isObjectType(parameter)) {
            return ClassName.get(Map.class);
        }
        return typeNameResolver.resolve(parameter.type());
    }

    private static String normalizeEnumTypeName(String input) {
        return CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, input);
    }

    private static boolean isEnumType(Protocol.DomainParameter parameter) {
        return parameter.enumerate() != null;
    }

    private static boolean isArrayType(Protocol.DomainParameter parameter) {
        return parameter.items() != null;
    }

    private static boolean isRefType(Protocol.DomainParameter parameter) {
        return parameter.ref() != null;
    }

    private static boolean isObjectType(Protocol.DomainParameter parameter) {
        return "object" .equals(parameter.type());
    }

    private static boolean isThis(String name) {
        return "this" .equals(name);
    }
}
