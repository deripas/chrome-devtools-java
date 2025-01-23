package org.deripas.chrome.devtools.client.transport.factory;

import com.google.common.reflect.AbstractInvocationHandler;
import lombok.RequiredArgsConstructor;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.deripas.chrome.devtools.client.transport.Request;
import org.deripas.chrome.devtools.client.transport.TransportCDP;

import javax.annotation.CheckForNull;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;

@RequiredArgsConstructor
public class DomainInvocationHandler extends AbstractInvocationHandler {

    private final TransportCDP transport;
    private final String domain;

    @CheckForNull
    @Override
    protected Object handleInvocation(Object proxy, Method method, @Nullable Object[] args) {
        final Request.RequestBuilder requestBuilder = Request.builder()
            .id(1)
            .method(domain + "." + method.getName());

        if (args != null && args.length > 0) {
            requestBuilder.params(args[0]);
        }

        final Object response = buildResponse(method.getGenericReturnType());
        transport.send(requestBuilder.build());
        return response;
    }

    private Object buildResponse(Type returnType) {
        if (returnType.equals(Void.TYPE)) {
            return null;
        }
        if (returnType instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) returnType;
            if (parameterizedType.getRawType().equals(CompletableFuture.class)) {
                Type actualType = parameterizedType.getActualTypeArguments()[0];
                // Здесь можно использовать actualType для создания экземпляра Response
                return new CompletableFuture<>();
            }
        }
        throw new IllegalArgumentException("Unsupported return type: " + returnType);
    }
}
