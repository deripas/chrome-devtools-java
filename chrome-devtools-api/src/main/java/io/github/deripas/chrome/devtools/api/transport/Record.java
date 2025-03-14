package io.github.deripas.chrome.devtools.api.transport;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.DEDUCTION;

@JsonTypeInfo(use = DEDUCTION)
@JsonSubTypes({
    @JsonSubTypes.Type(Response.Success.class),
    @JsonSubTypes.Type(Response.Failed.class),
    @JsonSubTypes.Type(Event.class)
})
public interface Record {

}
