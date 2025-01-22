package org.deripas.chrome.protocol.builder;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.palantir.javapoet.AnnotationSpec;
import com.palantir.javapoet.ClassName;
import com.palantir.javapoet.FieldSpec;
import com.palantir.javapoet.TypeName;
import com.palantir.javapoet.TypeSpec;
import lombok.*;
import lombok.experimental.UtilityClass;

import javax.lang.model.element.Modifier;

@UtilityClass
public class ValuerTypeBuilder {

    @Builder
    public static TypeSpec.Builder build(String typeName, TypeName valueType) {
        return TypeSpec.classBuilder(ClassName.bestGuess(typeName))
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
//                .addModifiers(Modifier.PRIVATE, Modifier.FINAL)
                .build());
    }
}
