package org.deripas.chrome.protocol;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record Protocol(
    Version version,
    List<Domain> domains
) {

    public record Version(int major, int minor) {
    }

    public record Domain(
        String domain,
        String description,
        boolean deprecated,
        boolean experimental,
        List<String> dependencies,
        List<DomainType> types,
        List<DomainCommand> commands,
        List<DomainEvent> events
    ) {
    }

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

    public record ArrayItemDescriptor(
        String type,
        @JsonProperty("enum")
        List<String> enumerate,
        @JsonProperty("$ref")
        String ref
    ) {
    }

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

    public record DomainEvent(
        String name,
        String description,
        boolean deprecated,
        boolean experimental,
        List<DomainParameter> parameters
    ) {
    }
}
