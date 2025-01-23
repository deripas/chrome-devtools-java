package org.deripas.chrome.devtools.client.transport.factory;

import com.google.common.reflect.AbstractInvocationHandler;
import lombok.RequiredArgsConstructor;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.deripas.chrome.devtools.client.transport.TransportCDP;

import javax.annotation.CheckForNull;
import java.lang.reflect.Method;

@RequiredArgsConstructor
public class ProtocolInvocationHandler extends AbstractInvocationHandler {

    private final TransportCDP transport;
    private final Factory factory;

    @CheckForNull
    @Override
    protected Object handleInvocation(Object proxy, Method method, @Nullable Object[] args) {
        final Class<?> domainType = method.getReturnType();
        return factory.createDomain(transport, domainType);
    }
}
