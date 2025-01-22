package org.deripas.chrome.protocol;

import com.palantir.javapoet.ClassName;
import com.palantir.javapoet.JavaFile;
import com.palantir.javapoet.TypeName;
import com.palantir.javapoet.TypeSpec;
import lombok.Generated;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.deripas.chrome.protocol.builder.Context;
import org.deripas.chrome.protocol.builder.DomainTypeBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static com.google.common.base.Preconditions.checkState;
import static java.util.stream.Collectors.toMap;

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
                    ctx.addType(type);
                }
            }
        }
    }

    private Stream<JavaFile> generateJavaFiles() {
        final Map<String, TypeName> globalTypes = getGlobalTypes(context);

        return context.values().stream()
            .flatMap(domainCtx -> {
                final Context ctx = createContext(domainCtx.getLocalTypes(), globalTypes);
                return domainCtx.getDomainTypes().stream()
                    .map(type -> DomainTypeBuilder.build(type, ctx))
                    .map(builder -> builder.addAnnotation(ClassName.get(Generated.class)))
                    .map(TypeSpec.Builder::build)
                    .map(type -> JavaFile.builder(packageName, type).build());
            });
    }

    private static Map<String, TypeName> getGlobalTypes(Map<String, DomainCtx> context) {
        return context.values()
            .stream()
            .map(DomainCtx::getGlobalTypes)
            .map(Map::entrySet)
            .flatMap(Collection::stream)
            .collect(toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private static Context createContext(Map<String, TypeName> localTypes, Map<String, TypeName> globalTypes) {
        return type -> Optional.ofNullable(localTypes.get(type))
            .or(() -> Optional.ofNullable(globalTypes.get(type)))
            .orElseGet(() -> getSystemTypeName(type));
    }

    private static TypeName getSystemTypeName(String type) {
        return switch (type) {
            case "string" -> TypeName.get(String.class);
            case "integer" -> TypeName.get(Integer.class);
            case "number" -> TypeName.get(Long.class);
            case "boolean" -> TypeName.get(Boolean.class);
            case "any" -> TypeName.get(Object.class);
            default -> throw new IllegalArgumentException("Unknown type: " + type);
        };
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

    @Getter
    @RequiredArgsConstructor
    private static class DomainCtx {
        private final Protocol.Domain domain;
        private final List<Protocol.DomainType> domainTypes = new ArrayList<>();
        private final Map<String, TypeName> localTypes = new HashMap<>();
        private final Map<String, TypeName> globalTypes = new HashMap<>();

        public void addType(Protocol.DomainType type) {
            final ClassName className = ClassName.bestGuess(type.id());
            final String globalKey = domain.domain() + "." + type.id();
            domainTypes.add(type);
            localTypes.put(type.id(), className);
            globalTypes.put(globalKey, className);
        }
    }
}
