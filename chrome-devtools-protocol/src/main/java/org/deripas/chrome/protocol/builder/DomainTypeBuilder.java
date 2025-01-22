package org.deripas.chrome.protocol.builder;

import com.palantir.javapoet.TypeSpec;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.deripas.chrome.protocol.Protocol;

import static com.google.common.base.Preconditions.checkState;

@Slf4j
@UtilityClass
public class DomainTypeBuilder {

    @Builder
    public static TypeSpec.Builder build(
        Protocol.DomainType domainType,
        TypeNameResolver typeNameResolver
    ) {
        TypeSpec.Builder builder = null;
        if (isEnumType(domainType)) {
            checkState("string" .equals(domainType.type()));
            builder = EnumTypeBuilder.builder()
                .typeName(domainType.id())
                .enumerate(domainType.enumerate())
                .build();
        }
        if (isArrayType(domainType)) {
            checkState("array" .equals(domainType.type()));
            builder = ArrayTypeBuilder.builder()
                .typeName(domainType.id())
                .itemDescriptor(domainType.items())
                .typeNameResolver(typeNameResolver)
                .build();
        }
        if (isObjectType(domainType)) {
            builder = ObjectTypeBuilder.builder()
                .typeName(domainType.id())
                .parameters(domainType.parameters())
                .typeNameResolver(typeNameResolver)
                .build();
        }
        if (builder == null) {
            log.debug("Building value type: {} ({})", domainType.id(), domainType.type());
            builder = ValuerTypeBuilder.builder()
                .typeName(domainType.id())
                .valueType(typeNameResolver.resolve(domainType.type()))
                .build();
        }
        if (StringUtils.isNotEmpty(domainType.description())) {
            builder.addJavadoc(domainType.description());
        }
        if (domainType.deprecated()) {
            builder.addAnnotation(Deprecated.class);
        }
        if (domainType.experimental()) {
            builder.addAnnotation(Experimental.class);
        }
        return builder;
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