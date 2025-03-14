package io.github.deripas.chrome.protocol.builder;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.palantir.javapoet.AnnotationSpec;
import com.palantir.javapoet.ClassName;
import com.palantir.javapoet.FieldSpec;
import com.palantir.javapoet.TypeName;
import com.palantir.javapoet.TypeSpec;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.experimental.UtilityClass;

import javax.lang.model.element.Modifier;

/**
 * Builder for value (Wrapper) types.
 */
@UtilityClass
public class ValuerTypeBuilder {

    @Builder
    public static TypeSpec.Builder build(String typeName, TypeName valueType) {
        return TypeSpec.classBuilder(typeName)
            .addModifiers(Modifier.PUBLIC)
            .addAnnotation(Value.class)
            .addAnnotation(AnnotationSpec.builder(RequiredArgsConstructor.class)
                .addMember("staticName", "$S", "of")
                .addMember("onConstructor_", "@$T", ClassName.get(JsonCreator.class))
                .build())
            .addAnnotation(AnnotationSpec.builder(Getter.class)
                .addMember("onMethod_", "@$T", ClassName.get(JsonValue.class))
                .build())
            .addField(FieldSpec.builder(valueType, "value")
                .build());
    }
}
