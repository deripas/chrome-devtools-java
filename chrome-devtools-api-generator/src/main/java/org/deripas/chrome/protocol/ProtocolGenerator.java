package org.deripas.chrome.protocol;

import com.google.common.base.CaseFormat;
import com.palantir.javapoet.ClassName;
import com.palantir.javapoet.JavaFile;
import com.palantir.javapoet.TypeSpec;
import lombok.Generated;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.deripas.chrome.protocol.builder.Context;
import org.deripas.chrome.protocol.builder.DataEventBuilder;
import org.deripas.chrome.protocol.builder.DomainRootTypeBuilder;
import org.deripas.chrome.protocol.builder.DomainTypeBuilder;
import org.deripas.chrome.protocol.builder.EventIdClassBuilder;
import org.deripas.chrome.protocol.builder.ProtocolRootTypeBuilder;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import static com.google.common.base.Preconditions.checkState;
import static java.util.Collections.emptyMap;
import static java.util.stream.Collectors.toMap;
import static org.apache.commons.lang3.ObjectUtils.defaultIfNull;

/**
 * Generates Java files from Chrome DevTools Protocol.
 */
@Slf4j
@RequiredArgsConstructor
public class ProtocolGenerator {

    private final String packageName;
    private final Map<String, DomainContext> domainContextMap = new HashMap<>();

    public void add(Protocol protocol) {
        for (Protocol.Domain domain : protocol.domains()) {
            final DomainContext ctx = new DomainContext(packageName, domain);
            final DomainContext old = domainContextMap.put(domain.domain(), ctx);
            checkState(old == null);
        }
    }

    public Stream<JavaFile> generateJavaFiles() {
        final Map<String, ClassName> globalTypes = mergeGlobalTypes(domainContextMap);
        globalTypes.put("@EventId", ClassName.get(packageName, "EventId"));
        return Stream.concat(
            generateDomainClasses(domainContextMap.values(), globalTypes),
            Stream.of(
                generateProtocolRootClass(domainContextMap.keySet(), globalTypes),
                generateEventIdClass(globalTypes)
            )
        );
    }

    private Stream<JavaFile> generateDomainClasses(
        Collection<DomainContext> domainContexts,
        Map<String, ClassName> globalTypes
    ) {
        return domainContexts.stream()
            .flatMap(domainContext -> {
                final Context ctx = createContext(domainContext.getLocalTypes(), globalTypes);
                return Stream.of(
                        generateDomainTypes(domainContext, ctx),
                        generateDomainEvent(domainContext, ctx),
                        Stream.of(
                            generateDomainRootType(domainContext, ctx)
                        )
                    )
                    .flatMap(s -> s);
            });
    }

    private JavaFile generateProtocolRootClass(
        Set<String> domains,
        Map<String, ClassName> globalTypes
    ) {
        final Context ctx = createContext(globalTypes);
        final TypeSpec.Builder builder = ProtocolRootTypeBuilder.build(domains, ctx);
        return toJavaFile(builder, packageName);
    }

    private JavaFile generateEventIdClass(
        Map<String, ClassName> globalTypes
    ) {
        final ClassName eventIdClassName = globalTypes.get("@EventId");
        final TypeSpec.Builder builder = EventIdClassBuilder.build(eventIdClassName);
        return toJavaFile(builder, eventIdClassName.packageName());
    }

    private static Stream<JavaFile> generateDomainTypes(
        DomainContext domainContext,
        Context ctx
    ) {
        return domainContext.getDomainTypes().stream()
            .map(type -> DomainTypeBuilder.build(type, ctx))
            .map(type -> toJavaFile(type, domainContext.getPackageName()));
    }

    private static Stream<JavaFile> generateDomainEvent(
        DomainContext domainContext,
        Context ctx
    ) {
        return domainContext.getDomainEvents().stream()
            .map(event -> {
                final ClassName typeName = ctx.resolveType(event.name());
                final TypeSpec.Builder builder = DataEventBuilder.builder()
                    .typeName(typeName.simpleName())
                    .domain(domainContext.getDomain().domain())
                    .event(event)
                    .ctx(ctx)
                    .build();
                return toJavaFile(builder, typeName.packageName());
            });
    }

    private static JavaFile generateDomainRootType(
        DomainContext domainContext,
        Context ctx
    ) {
        final Protocol.Domain domain = domainContext.getDomain();
        final TypeSpec.Builder rootType = DomainRootTypeBuilder.builder()
            .domain(domain)
            .ctx(ctx)
            .build();
        return toJavaFile(rootType, domainContext.getPackageName());
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

    private static Map<String, ClassName> mergeGlobalTypes(Map<String, DomainContext> context) {
        return context.values()
            .stream()
            .map(DomainContext::getGlobalTypes)
            .map(Map::entrySet)
            .flatMap(Collection::stream)
            .collect(toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private static Context createContext(Map<String, ClassName> types) {
        return createContext(types, emptyMap());
    }

    private static Context createContext(Map<String, ClassName> localTypes, Map<String, ClassName> globalTypes) {
        return type -> Optional.ofNullable(localTypes.get(type))
            .or(() -> Optional.ofNullable(globalTypes.get(type)))
            .orElseGet(() -> getSystemTypeName(type));
    }

    private static ClassName getSystemTypeName(String type) {
        return switch (type) {
            case "string" -> ClassName.get(String.class);
            case "integer" -> ClassName.get(Integer.class);
            case "number" -> ClassName.get(Double.class);
            case "boolean" -> ClassName.get(Boolean.class);
            case "any" -> ClassName.get(Object.class);
            case "object" -> ClassName.get(Map.class);
            default -> throw new IllegalArgumentException("Unknown type: " + type);
        };
    }

    /**
     * Context for a domain.
     */
    @Getter
    private static class DomainContext {
        private final String rootPackageName;
        private final String packageName;
        private final Protocol.Domain domain;
        private final Map<String, ClassName> localTypes = new HashMap<>();
        private final Map<String, ClassName> globalTypes = new HashMap<>();

        private DomainContext(String rootPackageName, Protocol.Domain domain) {
            this.rootPackageName = rootPackageName;
            this.packageName = rootPackageName + "." + domain.domain().toLowerCase(Locale.ROOT);
            this.domain = domain;

            if (domain.types() != null) {
                domain.types().forEach(this::registerDomainType);
            }
            if (domain.events() != null) {
                domain.events().forEach(this::registerDomainEvent);
            }
            registerDomainRootType(domain);
        }

        private void registerDomainRootType(Protocol.Domain domain) {
            globalTypes.put(domain.domain(), ClassName.get(packageName, domain.domain()));
        }

        private void registerDomainType(Protocol.DomainType type) {
            final String name = type.id();
            final ClassName className = ClassName.get(packageName, name);
            localTypes.put(name, className);
            globalTypes.put(globalName(name), className);
        }

        private void registerDomainEvent(Protocol.DomainEvent event) {
            final String name = event.name();
            final String eventClass = normalizeClassName(name) + "Event";
            final ClassName className = ClassName.get(packageName + ".event", eventClass);
            localTypes.put(name, className);
            globalTypes.put(globalName(name), className);
        }

        public List<Protocol.DomainType> getDomainTypes() {
            return defaultIfNull(domain.types(), Collections.emptyList());
        }

        public List<Protocol.DomainEvent> getDomainEvents() {
            return defaultIfNull(domain.events(), Collections.emptyList());
        }

        private String globalName(String name) {
            return domain.domain() + "." + name;
        }

        private static String normalizeClassName(String input) {
            return CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, input);
        }
    }
}
