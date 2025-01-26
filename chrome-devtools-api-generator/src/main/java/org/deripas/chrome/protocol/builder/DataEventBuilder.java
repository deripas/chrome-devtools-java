package org.deripas.chrome.protocol.builder;

import com.palantir.javapoet.ClassName;
import com.palantir.javapoet.FieldSpec;
import com.palantir.javapoet.ParameterizedTypeName;
import com.palantir.javapoet.TypeSpec;
import lombok.Builder;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.deripas.chrome.protocol.Protocol;

import javax.lang.model.element.Modifier;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

/**
 * Builder for event types.
 */
@Slf4j
@UtilityClass
public class DataEventBuilder {

    @Builder
    public static TypeSpec.Builder build(
        String typeName,
        Protocol.DomainEvent event,
        String domain,
        Context ctx
    ) {
        final TypeSpec.Builder type;
        final List<Protocol.DomainParameter> parameters = event.parameters();
        if (parameters == null) {
            log.debug("Building Map: {}", typeName);
            type = TypeSpec.classBuilder(typeName)
                .addModifiers(Modifier.PUBLIC);
        } else {
            log.debug("Building DTO: {} with {} fields", typeName, parameters.size());
            type = DataTypeBuilder.builder()
                .typeName(typeName)
                .parameters(parameters)
                .ctx(ctx)
                .build();
        }
        if (isNotEmpty(event.description())) {
            type.addJavadoc(JavadocUtil.normalize(event.description()));
        }

        final ClassName eventParamsClassName = ctx.resolveType(event.name());
        final ClassName eventIdClassName = ctx.resolveType("@EventId");
        final String method = domain + "." + event.name();

        type.addField(
            FieldSpec.builder(
                    ParameterizedTypeName.get(eventIdClassName, eventParamsClassName),
                    "ID",
                    Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                .initializer("new EventId<>($S, $T.class)", method, eventParamsClassName)
                .build()
        );

        return type;
    }
}