package org.deripas.chrome.protocol.api.webaudio;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.String;
import lombok.Generated;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;

/**
 * An unique ID for a graph object (AudioContext, AudioNode, AudioParam) in Web Audio API
 */
@Value
@RequiredArgsConstructor(
    staticName = "of",
    onConstructor_ = @JsonCreator
)
@Getter(
    onMethod_ = @JsonValue
)
@Generated
public class GraphObjectId {
  String value;
}
