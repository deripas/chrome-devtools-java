package org.deripas.chrome.protocol.builder;

import com.palantir.javapoet.MethodSpec;
import com.palantir.javapoet.TypeSpec;
import lombok.Builder;
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
        final TypeSpec.Builder builder = TypeSpec.interfaceBuilder("Protocol")
            .addModifiers(Modifier.PUBLIC);

        for (String domain : domains) {
            final String getterName = "get" + domain;
            builder.addMethod(
                MethodSpec.methodBuilder(getterName)
                    .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                    .returns(ctx.resolveType(domain))
                    .build()
            );
        }
        return builder;
    }
}
