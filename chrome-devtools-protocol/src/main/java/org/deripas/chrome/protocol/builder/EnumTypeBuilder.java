package org.deripas.chrome.protocol.builder;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.CaseFormat;
import com.palantir.javapoet.AnnotationSpec;
import com.palantir.javapoet.TypeSpec;
import lombok.Builder;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import javax.lang.model.element.Modifier;
import java.util.List;

@Slf4j
@UtilityClass
public class EnumTypeBuilder {

    @Builder
    public static TypeSpec.Builder build(String typeName, List<String> enumerate) {
        final TypeSpec.Builder builder = TypeSpec.enumBuilder(typeName)
            .addModifiers(Modifier.PUBLIC);

        enumerate.forEach(enumValue -> {
            final String name = normalizeEnumName(enumValue);
            log.debug("[{}] Adding enum constant: {} -> {}", typeName, name, enumValue);
            final TypeSpec type = TypeSpec.anonymousClassBuilder("")
                .addAnnotation(
                    AnnotationSpec.builder(JsonProperty.class)
                        .addMember("value", "$S", enumValue)
                        .build()
                )
                .build();
            builder.addEnumConstant(name, type);
        });
        return builder;
    }

    private static String normalizeEnumName(String input) {
        return getCaseFormat(input)
            .to(CaseFormat.UPPER_UNDERSCORE, input);
    }

    private static CaseFormat getCaseFormat(String input) {
        if (input.contains("-")) {
            return CaseFormat.LOWER_HYPHEN;
        } else {
            return CaseFormat.LOWER_CAMEL;
        }
    }
}
