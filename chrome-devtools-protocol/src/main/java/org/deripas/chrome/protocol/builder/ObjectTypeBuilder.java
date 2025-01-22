package org.deripas.chrome.protocol.builder;

import com.palantir.javapoet.ClassName;
import com.palantir.javapoet.TypeSpec;
import lombok.Builder;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.deripas.chrome.protocol.Protocol;

import java.util.List;
import java.util.Map;

@Slf4j
@UtilityClass
public class ObjectTypeBuilder {

    @Builder
    public static TypeSpec.Builder build(
        String typeName,
        List<Protocol.DomainParameter> parameters,
        TypeNameResolver typeNameResolver
    ) {
        if (parameters == null) {
            log.debug("Building object type: {} without parameters", typeName);
            return ValuerTypeBuilder.builder()
                .typeName(typeName)
                .valueType(ClassName.get(Map.class))
                .build();
        } else {
            log.debug("Building object type: {} with parameters {}", typeName, parameters.size());
            return DataTypeBuilder.builder()
                .typeName(typeName)
                .parameters(parameters)
                .typeNameResolver(typeNameResolver)
                .build();
        }
    }
}