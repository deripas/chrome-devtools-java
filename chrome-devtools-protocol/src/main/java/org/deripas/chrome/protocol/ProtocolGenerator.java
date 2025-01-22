package org.deripas.chrome.protocol;

import com.palantir.javapoet.ClassName;
import com.palantir.javapoet.JavaFile;
import com.palantir.javapoet.TypeName;
import com.palantir.javapoet.TypeSpec;
import lombok.Generated;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.deripas.chrome.protocol.builder.DomainTypeBuilder;
import org.deripas.chrome.protocol.builder.TypeNameResolver;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.google.common.base.Preconditions.checkState;

@Slf4j
@RequiredArgsConstructor
public class ProtocolGenerator {

    private final String packageName;
    private final Map<String, DomainCtx> context = new HashMap<>();

    public void add(Protocol protocol) {
        for (Protocol.Domain domain : protocol.domains()) {
            log.info("Domain: {}", domain.domain());
            final DomainCtx ctx = new DomainCtx(domain);
            final DomainCtx old = context.put(domain.domain(), ctx);
            checkState(old == null);

            if (domain.types() != null) {
                for (Protocol.DomainType type : domain.types()) {
                    log.info("Type: {}", type.id());
                    ctx.types.put(type.id(), type);
                }
            }
        }
    }

    private Stream<JavaFile> generateJavaFiles() {
        return buildTypes()
            .map(type -> JavaFile.builder(packageName, type).build());
    }

    private Stream<TypeSpec> buildTypes() {
        final Map<String, Protocol.DomainType> globalTypes = context.values().stream()
            .flatMap(ctx -> ctx.types.values()
                .stream()
                .map(type -> Map.entry(ctx.domain.domain() + "." + type.id(), type))
            )
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return context.values().stream()
            .flatMap(ctx -> {
                final TypeNameResolver resolver = createTypeNameResolver(ctx, globalTypes);
                return ctx.types.values().stream()
                    .map(type -> DomainTypeBuilder.build(type, resolver));
            })
            .map(builder -> builder.addAnnotation(ClassName.get(Generated.class)))
            .map(TypeSpec.Builder::build);
    }

    private static TypeNameResolver createTypeNameResolver(DomainCtx ctx, Map<String, Protocol.DomainType> globalTypes) {
        final TypeNameResolver resolver = new TypeNameResolver() {
            @Override
            public TypeName resolve(String type) {
                Protocol.DomainType localType = ctx.types.get(type);
                if (localType != null) {
                    return ClassName.bestGuess(localType.id());
                }
                Protocol.DomainType globalType = globalTypes.get(type);
                if (globalType != null) {
                    return ClassName.bestGuess(globalType.id());
                }

                return switch (type) {
                    case "string" -> TypeName.get(String.class);
                    case "integer" -> TypeName.get(Integer.class);
                    case "number" -> TypeName.get(Long.class);
                    case "boolean" -> TypeName.get(Boolean.class);
                    case "any" -> TypeName.get(Object.class);
                    default -> throw new IllegalArgumentException("Unknown type: " + type);
                };
            }
        };
        return resolver;
    }

    @SneakyThrows
    public static void main(String[] args) {
        final ProtocolGenerator generator = new ProtocolGenerator("org.deripas.chrome.protocol.generated");
        generator.add(ProtocolReader.read("protocol/browser_protocol.json"));
        generator.add(ProtocolReader.read("protocol/js_protocol.json"));

        final File dir = new File("/home/anton/IdeaProjects/chrome-devtools-java/chrome-devtools-protocol/src/test/java");
        final Stream<JavaFile> files = generator.generateJavaFiles();
        files.forEach(javaFile -> {
            try {
                javaFile.writeTo(dir);
            } catch (Exception e) {
                log.error("Failed to write file: {}", javaFile, e);
            }
        });
    }

    @RequiredArgsConstructor
    private static class DomainCtx {
        private final Protocol.Domain domain;
        private final Map<String, Protocol.DomainType> types = new HashMap<>();
    }
}
