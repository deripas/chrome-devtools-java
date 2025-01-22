package org.deripas.chrome.protocol;

import com.google.common.collect.Lists;
import com.palantir.javapoet.ClassName;
import com.palantir.javapoet.JavaFile;
import com.palantir.javapoet.TypeName;
import com.palantir.javapoet.TypeSpec;
import lombok.Generated;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.deripas.chrome.protocol.builder.Context;
import org.deripas.chrome.protocol.builder.DomainRootTypeBuilder;
import org.deripas.chrome.protocol.builder.DomainTypeBuilder;
import org.deripas.chrome.protocol.builder.ProtocolRootTypeBuilder;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.google.common.base.Preconditions.checkState;
import static java.util.stream.Collectors.toMap;
import static org.apache.commons.lang3.ObjectUtils.defaultIfNull;

/**
 * Generates Java files from Chrome DevTools Protocol.
 */
@Slf4j
@RequiredArgsConstructor
public class ProtocolGenerator {

    private final String packageName;
    private final Map<String, DomainContext> context = new HashMap<>();

    public void add(Protocol protocol) {
        for (Protocol.Domain domain : protocol.domains()) {
            final DomainContext ctx = new DomainContext(packageName, domain);
            final DomainContext old = context.put(domain.domain(), ctx);
            checkState(old == null);
        }
    }

    public Stream<JavaFile> generateJavaFiles() {
        final Map<String, TypeName> globalTypes = getGlobalTypes(context);
        final Collection<DomainContext> domainContexts = context.values();
        final List<Protocol.Domain> domains = domainContexts.stream().map(DomainContext::getDomain).toList();
        return Stream.concat(
            domainContexts.stream()
                .flatMap(domainContext -> {
                    final Context ctx = createContext(domainContext.getLocalTypes(), globalTypes);
                    return Stream.concat(
                            generateDomainTypes(domainContext.getDomainTypes(), ctx),
                            Stream.of(
                                generateDomainRootType(domainContext.getDomain(), ctx)
                            )
                        )
                        .map(builder -> toJavaFile(builder, domainContext.getPackageName()));
                }),
            Stream.of(
                generateProtocolRootType(domains, createContext(Collections.emptyMap(), globalTypes))
            )
        );
    }

    private JavaFile generateProtocolRootType(
        List<Protocol.Domain> domains,
        Context ctx
    ) {
        final TypeSpec.Builder builder = ProtocolRootTypeBuilder.build(domains, ctx);
        return toJavaFile(builder, packageName);
    }

    private static JavaFile toJavaFile(
        TypeSpec.Builder typeBuilder,
        String packageName
    ) {
        final ClassName generatedAnnotation = ClassName.get(Generated.class);
        return Optional.of(typeBuilder)
            .map(builder -> builder.addAnnotation(generatedAnnotation))
            .map(TypeSpec.Builder::build)
            .map(type -> JavaFile.builder(packageName, type))
            .map(JavaFile.Builder::build)
            .get();
    }

    private static Stream<TypeSpec.Builder> generateDomainTypes(
        List<Protocol.DomainType> domainTypes,
        Context ctx
    ) {
        return domainTypes.stream()
            .map(type -> DomainTypeBuilder.build(type, ctx));
    }

    private static TypeSpec.Builder generateDomainRootType(
        Protocol.Domain domain,
        Context ctx
    ) {
        return DomainRootTypeBuilder.build(domain, ctx);
    }

    private static Map<String, TypeName> getGlobalTypes(Map<String, DomainContext> context) {
        return context.values()
            .stream()
            .map(DomainContext::getGlobalTypes)
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
            case "any", "object" -> TypeName.get(Object.class);
            default -> throw new IllegalArgumentException("Unknown type: " + type);
        };
    }

    /**
     * Context for a domain.
     */
    @Getter
    private static class DomainContext {
        private final String packageName;
        private final Protocol.Domain domain;
        private final Map<String, TypeName> localTypes = new HashMap<>();
        private final Map<String, TypeName> globalTypes = new HashMap<>();

        private DomainContext(String rootPackageName, Protocol.Domain domain) {
            this.packageName = rootPackageName + "." + domain.domain().toLowerCase(Locale.ROOT);
            this.domain = domain;

            if (domain.types() != null) {
                domain.types().forEach(this::addDomainType);
            }
            final ClassName domainClassName = ClassName.get(packageName, domain.domain());
            globalTypes.put(domain.domain(), domainClassName);
        }

        private void addDomainType(Protocol.DomainType type) {
            final ClassName className = ClassName.get(packageName, type.id());
            final String globalKey = domain.domain() + "." + type.id();
            localTypes.put(type.id(), className);
            globalTypes.put(globalKey, className);
        }

        public List<Protocol.DomainType> getDomainTypes() {
            return defaultIfNull(domain.types(), Collections.emptyList());
        }
    }
}
