package io.github.deripas.chrome.protocol.builder;

import com.google.common.base.CaseFormat;
import com.palantir.javapoet.ClassName;
import com.palantir.javapoet.FieldSpec;
import com.palantir.javapoet.MethodSpec;
import com.palantir.javapoet.TypeSpec;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.UtilityClass;

import javax.lang.model.element.Modifier;
import java.util.Set;

@UtilityClass
public class ProtocolRootTypeBuilder {

    @Builder
    public static TypeSpec.Builder build(
        Set<String> domains,
        Context ctx
    ) {
        final ClassName sessionClassName = ctx.resolveType("$Session");
        final ClassName className = ClassName.bestGuess("Protocol");
        final TypeSpec.Builder builder = TypeSpec.classBuilder(className)
            .addModifiers(Modifier.PUBLIC)
            .addAnnotation(Getter.class)
            .addField(FieldSpec.builder(sessionClassName, "session")
                .addModifiers(Modifier.PRIVATE, Modifier.FINAL)
                .build());

        final MethodSpec.Builder constructorBuilder = MethodSpec.constructorBuilder()
            .addModifiers(Modifier.PUBLIC)
            .addParameter(sessionClassName, "session")
            .addStatement("this.session = session");

        for (String domain : domains) {
            final String domainFieldName = normalizeFieldName(domain);
            final ClassName domainClassName = ctx.resolveType(domain);
            builder.addField(FieldSpec.builder(domainClassName, domainFieldName)
                .addModifiers(Modifier.PRIVATE, Modifier.FINAL)
                .build());

            constructorBuilder.addStatement("this.$N = new $T(session)", domainFieldName, domainClassName);
        }
        return builder.addMethod(constructorBuilder.build())
            .addMethod(MethodSpec.methodBuilder("withSessionId")
                .addModifiers(Modifier.PUBLIC)
                .addParameter(ClassName.get(String.class), "sessionId")
                .addStatement("return new Protocol(session.withSessionId(sessionId))")
                .returns(className)
                .build())
            .addMethod(MethodSpec.methodBuilder("close")
                .addModifiers(Modifier.PUBLIC)
                .addStatement("session.close()")
                .build());
    }

    private static String normalizeFieldName(String input) {
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, input);
    }
}
