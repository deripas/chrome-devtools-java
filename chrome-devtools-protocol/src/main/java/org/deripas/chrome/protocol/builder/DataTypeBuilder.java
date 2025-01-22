package org.deripas.chrome.protocol.builder;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.CaseFormat;
import com.palantir.javapoet.AnnotationSpec;
import com.palantir.javapoet.ClassName;
import com.palantir.javapoet.FieldSpec;
import com.palantir.javapoet.ParameterizedTypeName;
import com.palantir.javapoet.TypeName;
import com.palantir.javapoet.TypeSpec;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.deripas.chrome.protocol.Protocol;

import javax.annotation.Nullable;
import javax.lang.model.element.Modifier;
import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

/**
 * Builder for data (POJO) types.
 */
@Slf4j
@UtilityClass
public class DataTypeBuilder {

    @Builder
    public static TypeSpec.Builder build(
        String typeName,
        List<Protocol.DomainParameter> parameters,
        Context ctx
    ) {
        checkNotNull(parameters);
        final TypeSpec.Builder builder = TypeSpec.classBuilder(typeName)
            .addModifiers(Modifier.PUBLIC)
            .addAnnotation(Data.class)
            .addAnnotation(AnnotationSpec.builder(Builder.class)
                .addMember("toBuilder", "$L", "true")
                .build());

        for (Protocol.DomainParameter parameter : parameters) {
            final TypeName type = resolveType(parameter, builder, ctx);
            final String fieldName = normalizeFieldName(parameter.name());
            log.debug("[{}] Adding field: {} type {}", typeName, parameter.name(), type);

            final FieldSpec.Builder fieldBuilder = FieldSpec.builder(type, fieldName)
                .addModifiers(Modifier.PRIVATE, Modifier.FINAL);
            checkFieldName(fieldBuilder, fieldName, parameter.name());
            addMetaData(fieldBuilder, parameter);
            builder.addField(fieldBuilder.build());
        }
        return builder;
    }

    private static void checkFieldName(
        FieldSpec.Builder fieldBuilder,
        String fieldName,
        String parameterName
    ) {
        if (fieldName.equals(parameterName)) {
            // do nothing
            return;
        }
        log.warn("Field was renamed {} to {}", parameterName, fieldName);
        fieldBuilder.addAnnotation(
            AnnotationSpec.builder(JsonProperty.class)
                .addMember("value", "$S", parameterName)
                .build()
        );
    }

    private static void addMetaData(FieldSpec.Builder builder, Protocol.DomainParameter parameter) {
        if (isNotEmpty(parameter.description())) {
            builder.addJavadoc(JavadocUtil.normalize(parameter.description()));
        }
        if (parameter.optional()) {
            builder.addAnnotation(Nullable.class);
        }
        if (parameter.experimental()) {
            builder.addAnnotation(Experimental.class);
        }
        if (parameter.deprecated()) {
            builder.addAnnotation(Deprecated.class);
        }
    }

    private static TypeName resolveType(
        Protocol.DomainParameter parameter,
        TypeSpec.Builder builder,
        Context ctx
    ) {
        if (isRefType(parameter)) {
            return ctx.resolveType(parameter.ref());
        }
        if (isArrayType(parameter)) {
            checkState("array".equals(parameter.type()));
            final TypeName itemType = ctx.resolveArrayItemType(parameter.items());
            return ParameterizedTypeName.get(ClassName.get(List.class), itemType);
        }
        if (isEnumType(parameter)) {
            final String enumTypeName = normalizeEnumTypeName(parameter.name());
            final TypeSpec.Builder enumBuilder = EnumTypeBuilder.builder()
                .typeName(enumTypeName)
                .enumerate(parameter.enumerate())
                .build();
            builder.addType(enumBuilder.build());
            return ClassName.bestGuess(enumTypeName);
        }
        checkState(parameter.type() != null);
        if (isObjectType(parameter)) {
            return ClassName.get(Map.class);
        }
        return ctx.resolveType(parameter.type());
    }

    private static String normalizeFieldName(String input) {
        if ("this".equals(input)) {
            return "thisRef";
        }
        return input;
    }

    private static String normalizeEnumTypeName(String input) {
        return CaseFormat.LOWER_CAMEL
            .to(CaseFormat.UPPER_CAMEL, input);
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
        return "object".equals(parameter.type());
    }
}
