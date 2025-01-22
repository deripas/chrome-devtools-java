package org.deripas.chrome.protocol.builder;

import com.palantir.javapoet.ClassName;
import com.palantir.javapoet.ParameterizedTypeName;
import com.palantir.javapoet.TypeName;
import com.palantir.javapoet.TypeSpec;
import lombok.Builder;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.deripas.chrome.protocol.Protocol;

import java.util.List;

import static com.google.common.base.Preconditions.checkState;

@Slf4j
@UtilityClass
public class ArrayTypeBuilder {

    @Builder
    public static TypeSpec.Builder build(
        String typeName,
        Protocol.ArrayItemDescriptor itemDescriptor,
        TypeNameResolver typeNameResolver
    ) {
        log.debug("Building array type: {}", typeName);
        final TypeName itemType = typeNameResolver.resolveArrayItemType(itemDescriptor);
        return ValuerTypeBuilder.builder()
            .typeName(typeName)
            .valueType(ParameterizedTypeName.get(ClassName.get(List.class), itemType))
            .build();
    }


}
