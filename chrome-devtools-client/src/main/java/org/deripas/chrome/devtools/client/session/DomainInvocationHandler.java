package org.deripas.chrome.devtools.client.session;

import com.google.common.reflect.AbstractInvocationHandler;
import lombok.RequiredArgsConstructor;
import org.checkerframework.checker.nullness.qual.Nullable;

import javax.annotation.CheckForNull;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;

import static com.google.common.base.Preconditions.checkArgument;

@RequiredArgsConstructor
public class DomainInvocationHandler extends AbstractInvocationHandler {

    private final Class<?> domainType;
    private final SessionContext context;

    @CheckForNull
    @Override
    protected Object handleInvocation(Object proxy, Method method, @Nullable Object[] args) {
        checkArgument(method.getReturnType().equals(CompletableFuture.class));
        final Class<?> responseType = getResponseType(method);
        return context.send(
            getMethodName(domainType, method),
            getArgument(args),
            responseType
        );
    }

    private static Object getArgument(@Nullable Object[] args) {
        if (args != null && args.length > 0) {
            return args[0];
        } else {
            return null;
        }
    }

    private static String getMethodName(Class<?> type, Method method) {
        return type.getSimpleName() + "." + method.getName();
    }

    private static Class<?> getResponseType(Method method) {
        final Type genericReturnType = method.getGenericReturnType();
        final ParameterizedType parameterizedType = (ParameterizedType) genericReturnType;
        return (Class<?>) parameterizedType.getActualTypeArguments()[0];
    }
}
