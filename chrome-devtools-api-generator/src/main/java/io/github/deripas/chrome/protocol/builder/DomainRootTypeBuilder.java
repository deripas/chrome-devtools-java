package io.github.deripas.chrome.protocol.builder;

import com.google.common.base.CaseFormat;
import com.palantir.javapoet.ClassName;
import com.palantir.javapoet.FieldSpec;
import com.palantir.javapoet.MethodSpec;
import com.palantir.javapoet.ParameterizedTypeName;
import com.palantir.javapoet.TypeSpec;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.experimental.UtilityClass;
import io.github.deripas.chrome.protocol.Protocol;

import javax.lang.model.element.Modifier;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import static com.google.common.base.Preconditions.checkState;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

@UtilityClass
public class DomainRootTypeBuilder {

    @Builder
    public static TypeSpec.Builder build(Protocol.Domain domain, Context ctx) {
        checkState(domain.commands() != null);
        final ClassName sessionClassName = ctx.resolveType("$Session");
        final ClassName disposableClassName = ctx.resolveType("$Disposable");

        final TypeSpec.Builder builder = TypeSpec.classBuilder(domain.domain())
            .addModifiers(Modifier.PUBLIC)
            .addAnnotation(RequiredArgsConstructor.class)
            .addField(FieldSpec.builder(sessionClassName, "session")
                .addModifiers(Modifier.PRIVATE, Modifier.FINAL)
                .build());

        for (Protocol.DomainCommand command : domain.commands()) {
            final MethodSpec.Builder methodBuilder = MethodSpec.methodBuilder(command.name())
                .addModifiers(Modifier.PUBLIC);
            addMetaData(methodBuilder, command);

            final String argument;
            if (command.parameters() != null) {
                final String request = normalizeClassName(command.name()) + "Request";
                methodBuilder.addParameter(ClassName.bestGuess(request), "request");
                builder.addType(
                    DataTypeBuilder.builder()
                        .typeName(request)
                        .parameters(command.parameters())
                        .ctx(ctx)
                        .build()
                        .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                        .build()
                );
                argument = "request";
            } else {
                argument = "null";
            }

            final ClassName responseType;
            if (command.returns() != null) {
                final String response = normalizeClassName(command.name()) + "Response";
                builder.addType(
                    DataTypeBuilder.builder()
                        .typeName(response)
                        .parameters(command.returns())
                        .ctx(ctx)
                        .build()
                        .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                        .build()
                );
                responseType = ClassName.bestGuess(response);
            } else {
                responseType = ClassName.get(Void.class);
            }

            final String methodName = domain.domain() + "." + command.name();
            final MethodSpec methodSpec = methodBuilder
                .returns(ParameterizedTypeName.get(
                    ClassName.get(CompletableFuture.class),
                    responseType
                ))
                .addCode("return session.send($S, $L, $T.class);", methodName, argument, responseType)
                .build();
            builder.addMethod(methodSpec);
        }

        for (Protocol.DomainEvent event : domain.events()) {
            final String eventName = normalizeClassName(event.name());
            final String eventClassName = eventName + "Event";
            final TypeSpec.Builder eventBuilder = DataEventBuilder
                .build(
                    eventClassName,
                    event,
                    ctx
                )
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC);
            builder.addType(eventBuilder.build());

            final String methodName = domain.domain() + "." + event.name();
            final ClassName eventType = ClassName.bestGuess(eventClassName);
            final MethodSpec methodSpec = MethodSpec.methodBuilder("on" + eventName)
                .addModifiers(Modifier.PUBLIC)
                .addParameter(ParameterizedTypeName.get(
                    ClassName.get(Consumer.class),
                    eventType
                ), "listener")
                .returns(disposableClassName)
                .addCode("return session.subscribe($S, $L, $T.class);", methodName, "listener", eventType)
                .build();
            builder.addMethod(methodSpec);
        }

        addMetaData(builder, domain);
        return builder;
    }

    private static String normalizeClassName(String input) {
        return CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, input);
    }

    private static void addMetaData(
        MethodSpec.Builder methodBuilder,
        Protocol.DomainCommand command
    ) {
        if (isNotEmpty(command.description())) {
            methodBuilder.addJavadoc(JavadocUtil.normalize(command.description()));
        }
        if (command.deprecated()) {
            methodBuilder.addAnnotation(Deprecated.class);
        }
        if (command.experimental()) {
            //TODO: fix it, Experimental cannot be used in METHOD
//            methodBuilder.addAnnotation(Experimental.class);
        }
    }

    private static void addMetaData(
        TypeSpec.Builder builder,
        Protocol.Domain domain
    ) {
        if (isNotEmpty(domain.description())) {
            builder.addJavadoc(JavadocUtil.normalize(domain.description()));
        }
        if (domain.deprecated()) {
            builder.addAnnotation(Deprecated.class);
        }
        if (domain.experimental()) {
            builder.addAnnotation(Experimental.class);
        }
    }
}
