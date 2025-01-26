package org.deripas.chrome.protocol.builder;

import com.palantir.javapoet.ClassName;
import com.palantir.javapoet.MethodSpec;
import com.palantir.javapoet.ParameterizedTypeName;
import com.palantir.javapoet.TypeSpec;
import com.palantir.javapoet.TypeVariableName;
import lombok.Builder;
import lombok.experimental.UtilityClass;

import javax.lang.model.element.Modifier;

@UtilityClass
public class EventIdClassBuilder {

    @Builder
    public static TypeSpec.Builder build(
        ClassName eventMethodType
    ) {
        final TypeVariableName generic = TypeVariableName.get("T");
        final ParameterizedTypeName typeName = ParameterizedTypeName.get(
            ClassName.get(Class.class),
            generic
        );
        return TypeSpec.recordBuilder(eventMethodType)
            .addModifiers(Modifier.PUBLIC)
            .addTypeVariable(generic)
            .recordConstructor(
                MethodSpec.constructorBuilder()
                    .addParameter(String.class, "method")
                    .addParameter(typeName, "type")
                    .build()
            );
    }
}
