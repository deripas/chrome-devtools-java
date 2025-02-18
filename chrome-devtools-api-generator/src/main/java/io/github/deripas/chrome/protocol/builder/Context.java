package io.github.deripas.chrome.protocol.builder;

import com.palantir.javapoet.ClassName;
import io.github.deripas.chrome.protocol.Protocol;

import static com.google.common.base.Preconditions.checkState;

/**
 * Context for building.
 */
public interface Context {

    ClassName resolveType(String type);

    default ClassName resolveArrayItemType(
        Protocol.ArrayItemDescriptor items
    ) {
        if (items.ref() != null) {
            return resolveType(items.ref());
        }
        checkState(items.type() != null);
        return resolveType(items.type());
    }
}
