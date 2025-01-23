package org.deripas.chrome.protocol.builder;

import com.palantir.javapoet.MethodSpec;
import com.palantir.javapoet.TypeSpec;
import lombok.Builder;
import lombok.experimental.UtilityClass;
import org.deripas.chrome.protocol.Protocol;

import javax.lang.model.element.Modifier;
import java.util.List;

@UtilityClass
public class ProtocolRootTypeBuilder {

    @Builder
    public static TypeSpec.Builder build(
        List<Protocol.Domain> domains,
        Context ctx
    ) {
        final TypeSpec.Builder builder = TypeSpec.interfaceBuilder("Protocol")
            .addModifiers(Modifier.PUBLIC);

        for (Protocol.Domain domain : domains) {
            final String getterName = "get" + domain.domain();
            builder.addMethod(
                MethodSpec.methodBuilder(getterName)
                    .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                    .returns(ctx.resolveType(domain.domain()))
                    .build()
            );
        }
        return builder;
    }
}
