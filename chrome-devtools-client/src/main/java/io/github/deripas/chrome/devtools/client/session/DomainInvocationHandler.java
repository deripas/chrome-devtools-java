package io.github.deripas.chrome.devtools.client.session;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.reflect.AbstractInvocationHandler;
import lombok.RequiredArgsConstructor;
import org.checkerframework.checker.nullness.qual.Nullable;
import io.github.deripas.chrome.devtools.api.Disposable;

import javax.annotation.CheckForNull;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

@RequiredArgsConstructor
public class DomainInvocationHandler extends AbstractInvocationHandler {

    private final Class<?> domainType;
    private final SessionContext context;

    @CheckForNull
    @Override
    protected Object handleInvocation(Object proxy, Method method, @Nullable Object[] args) {
        final Class<?> returnType = method.getReturnType();
        if (returnType.equals(CompletableFuture.class)) {
            final Class<?> responseType = getResponseType(method);
            return context.send(
                getMethodName(domainType, method.getName()),
                getArgument(args),
                responseType
            );
        }
        if (returnType.equals(Disposable.class)) {
            final Class<?> responseType = getEventType(method);
            final String eventName = responseType.getAnnotation(JsonTypeName.class).value();
            final Consumer consumer = (Consumer<?>) args[0];
            return context.subscribe(
                getMethodName(domainType, eventName),
                responseType,
                consumer
            );
        }
        throw new UnsupportedOperationException("Method not supported: " + method.getName());
    }

    private static Object getArgument(@Nullable Object[] args) {
        if (args != null && args.length > 0) {
            return args[0];
        } else {
            return null;
        }
    }

    private static String getMethodName(Class<?> type, String name) {
        return type.getSimpleName() + "." + name;
    }

    private static Class<?> getResponseType(Method method) {
        final Type genericReturnType = method.getGenericReturnType();
        final ParameterizedType parameterizedType = (ParameterizedType) genericReturnType;
        return (Class<?>) parameterizedType.getActualTypeArguments()[0];
    }

    private static Class<?> getEventType(Method method) {
        final Type listener = method.getGenericParameterTypes()[0];
        final ParameterizedType parameterizedType = (ParameterizedType) listener;
        return (Class<?>) parameterizedType.getActualTypeArguments()[0];
    }
}
