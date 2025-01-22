package org.deripas.chrome.protocol.builder;

import com.palantir.javapoet.ClassName;
import com.palantir.javapoet.ParameterizedTypeName;
import com.palantir.javapoet.TypeName;
import com.palantir.javapoet.TypeSpec;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.deripas.chrome.protocol.Protocol;

import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkState;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

/**
 * Builder for domain types.
 */
@Slf4j
@UtilityClass
public class DomainTypeBuilder {

    @Builder
    public static TypeSpec.Builder build(
        Protocol.DomainType domainType,
        Context ctx
    ) {
        final TypeSpec.Builder builder = createBuilder(domainType, ctx);
        addMetaData(builder, domainType);
        return builder;
    }

    private static TypeSpec.Builder createBuilder(
        Protocol.DomainType domainType,
        Context ctx
    ) {
        if (isEnumType(domainType)) {
            checkState("string".equals(domainType.type()));
            log.debug("Building Enum: {}", domainType.id());
            return EnumTypeBuilder.builder()
                .typeName(domainType.id())
                .enumerate(domainType.enumerate())
                .build();
        }
        if (isArrayType(domainType)) {
            checkState("array".equals(domainType.type()));
            final TypeName itemType = ctx.resolveArrayItemType(domainType.items());
            log.debug("Building Array: {}<{}>", domainType.type(), itemType);
            return ValuerTypeBuilder.builder()
                .typeName(domainType.id())
                .valueType(ParameterizedTypeName.get(ClassName.get(List.class), itemType))
                .build();
        }
        if (isObjectType(domainType)) {
            final List<Protocol.DomainParameter> parameters = domainType.parameters();
            if (parameters == null) {
                log.debug("Building Map: {}", domainType.id());
                return ValuerTypeBuilder.builder()
                    .typeName(domainType.id())
                    .valueType(ClassName.get(Map.class))
                    .build();
            } else {
                log.debug("Building DTO: {} with {} fields", domainType.id(), parameters.size());
                return DataTypeBuilder.builder()
                    .typeName(domainType.id())
                    .parameters(parameters)
                    .ctx(ctx)
                    .build();
            }
        }

        log.debug("Building Value: {}<{}>", domainType.id(), domainType.type());
        return ValuerTypeBuilder.builder()
            .typeName(domainType.id())
            .valueType(ctx.resolveType(domainType.type()))
            .build();
    }

    private static void addMetaData(TypeSpec.Builder builder, Protocol.DomainType domainType) {
        if (isNotEmpty(domainType.description())) {
            builder.addJavadoc(domainType.description());
        }
        if (domainType.deprecated()) {
            builder.addAnnotation(Deprecated.class);
        }
        if (domainType.experimental()) {
            builder.addAnnotation(Experimental.class);
        }
    }

    private static boolean isEnumType(Protocol.DomainType domainType) {
        return domainType.enumerate() != null;
    }

    private static boolean isArrayType(Protocol.DomainType domainType) {
        return domainType.items() != null;
    }

    private static boolean isObjectType(Protocol.DomainType domainType) {
        return "object".equals(domainType.type());
    }
}
