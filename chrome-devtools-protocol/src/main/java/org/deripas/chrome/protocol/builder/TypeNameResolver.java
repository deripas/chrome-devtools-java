package org.deripas.chrome.protocol.builder;

import com.palantir.javapoet.TypeName;
import org.deripas.chrome.protocol.Protocol;

import static com.google.common.base.Preconditions.checkState;

public interface TypeNameResolver {

    TypeName resolve(String type);

    default TypeName resolveArrayItemType(
        Protocol.ArrayItemDescriptor items
    ) {
        checkState(items.enumerate() == null);
        if (items.ref() != null) {
            return resolve(items.ref());
        }
        if (items.type() != null) {
            return resolve(items.type());
        }
        throw new UnsupportedOperationException("type is not supported");
    }
}
