package org.deripas.chrome.protocol.builder;

import com.palantir.javapoet.TypeName;
import org.deripas.chrome.protocol.Protocol;

import static com.google.common.base.Preconditions.checkState;

public interface Context {

    TypeName resolveType(String type);

    default TypeName resolveArrayItemType(
        Protocol.ArrayItemDescriptor items
    ) {
        checkState(items.enumerate() == null);
        if (items.ref() != null) {
            return resolveType(items.ref());
        }
        checkState(items.type() != null);
        return resolveType(items.type());
    }
}
