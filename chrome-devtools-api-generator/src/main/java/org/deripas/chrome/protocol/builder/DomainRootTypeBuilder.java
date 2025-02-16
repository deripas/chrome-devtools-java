package org.deripas.chrome.protocol.builder;

import com.google.common.base.CaseFormat;
import com.palantir.javapoet.ClassName;
import com.palantir.javapoet.MethodSpec;
import com.palantir.javapoet.ParameterizedTypeName;
import com.palantir.javapoet.TypeSpec;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.experimental.UtilityClass;
import org.deripas.chrome.protocol.Protocol;

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
        final TypeSpec.Builder builder = TypeSpec.interfaceBuilder(domain.domain())
            .addModifiers(Modifier.PUBLIC);

        for (Protocol.DomainCommand command : domain.commands()) {
            final MethodSpec.Builder methodBuilder = MethodSpec.methodBuilder(command.name())
                .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT);
            addMetaData(methodBuilder, command);

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
            }

            if (command.returns() != null) {
                final String response = normalizeClassName(command.name()) + "Response";
                methodBuilder.returns(ParameterizedTypeName.get(
                    ClassName.get(CompletableFuture.class),
                    ClassName.bestGuess(response)
                ));
                builder.addType(
                    DataTypeBuilder.builder()
                        .typeName(response)
                        .parameters(command.returns())
                        .ctx(ctx)
                        .build()
                        .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                        .build()
                );
            } else {
                methodBuilder.returns(ParameterizedTypeName.get(
                    ClassName.get(CompletableFuture.class),
                    ClassName.get(Void.class)
                ));
            }
            builder.addMethod(methodBuilder.build());
        }

        final ClassName disposableClassName = ctx.resolveType("@Disposable");
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

            final MethodSpec.Builder methodBuilder = MethodSpec.methodBuilder("on" + eventName)
                .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT);
            methodBuilder.addParameter(ParameterizedTypeName.get(
                ClassName.get(Consumer.class),
                ClassName.bestGuess(eventClassName)
            ), "listener");
            methodBuilder.returns(disposableClassName);
            builder.addMethod(methodBuilder.build());
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
