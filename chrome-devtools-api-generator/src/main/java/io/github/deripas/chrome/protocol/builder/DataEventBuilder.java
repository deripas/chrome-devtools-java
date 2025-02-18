package io.github.deripas.chrome.protocol.builder;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.palantir.javapoet.AnnotationSpec;
import com.palantir.javapoet.TypeSpec;
import lombok.Builder;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import io.github.deripas.chrome.protocol.Protocol;

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
        type.addAnnotation(
            AnnotationSpec.builder(JsonTypeName.class)
                .addMember("value", "$S", event.name())
                .build()
        );
        return type;
    }
}