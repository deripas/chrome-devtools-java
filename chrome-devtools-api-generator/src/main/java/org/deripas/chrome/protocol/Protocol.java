package org.deripas.chrome.protocol;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;

import java.util.List;

/**
 * Chrome DevTools Protocol dto.
 */
public record Protocol(
    Version version,
    List<Domain> domains
) {

    /**
     * Version of the protocol.
     */
    public record Version(int major, int minor) {
    }

    /**
     * Domain of the protocol.
     */
    public record Domain(
        String domain,
        String description,
        boolean deprecated,
        boolean experimental,
        List<String> dependencies,
        @JsonSetter(nulls= Nulls.AS_EMPTY)
        List<DomainType> types,
        @JsonSetter(nulls= Nulls.AS_EMPTY)
        List<DomainCommand> commands,
        @JsonSetter(nulls= Nulls.AS_EMPTY)
        List<DomainEvent> events
    ) {
    }

    /**
     * Type of the domain.
     */
    public record DomainType(
        String id,
        String description,
        boolean deprecated,
        boolean experimental,
        String type,
        @JsonProperty("properties")
        List<DomainParameter> parameters,
        @JsonProperty("enum")
        List<String> enumerate,
        ArrayItemDescriptor items
    ) {
    }

    /**
     * Parameter of the domain.
     */
    public record DomainParameter(
        String name,
        String description,
        String type,
        boolean optional,
        boolean deprecated,
        boolean experimental,
        @JsonProperty("enum")
        List<String> enumerate,
        ArrayItemDescriptor items,
        @JsonProperty("$ref")
        String ref
    ) {
    }

    /**
     * Array item descriptor.
     */
    public record ArrayItemDescriptor(
        String type,
        @JsonProperty("$ref")
        String ref
    ) {
    }

    /**
     * Command of the domain.
     */
    public record DomainCommand(
        String name,
        String description,
        boolean deprecated,
        boolean experimental,
        String redirect,
        List<DomainParameter> parameters,
        List<DomainParameter> returns
    ) {
    }

    /**
     * Event of the domain.
     */
    public record DomainEvent(
        String name,
        String description,
        boolean deprecated,
        boolean experimental,
        List<DomainParameter> parameters
    ) {
    }
}
