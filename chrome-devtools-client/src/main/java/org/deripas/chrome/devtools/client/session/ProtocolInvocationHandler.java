package org.deripas.chrome.devtools.client.session;

import com.google.common.reflect.AbstractInvocationHandler;
import com.google.common.reflect.Reflection;
import lombok.RequiredArgsConstructor;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.deripas.chrome.devtools.client.transport.CDPTransport;

import javax.annotation.CheckForNull;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class ProtocolInvocationHandler extends AbstractInvocationHandler {

    private final CDPTransport transport;
    private final SessionContext convertor;
    private final Map<Class<?>, Object> domainCache = new HashMap<>();

    @CheckForNull
    @Override
    protected Object handleInvocation(Object proxy, Method method, @Nullable Object[] args) {
        if (!method.getName().startsWith("get")) {
            throw new UnsupportedOperationException("Method not supported: " + method.getName());
        }
        return domainCache.computeIfAbsent(
            method.getReturnType(),
            this::createDomain
        );
    }

    private Object createDomain(Class<?> domainType) {
        return Reflection.newProxy(
            domainType,
            new DomainInvocationHandler(transport, domainType, convertor)
        );
    }
}
