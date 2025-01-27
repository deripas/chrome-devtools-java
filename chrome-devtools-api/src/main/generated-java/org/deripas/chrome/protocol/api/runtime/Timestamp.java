package org.deripas.chrome.protocol.api.runtime;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Double;
import lombok.Generated;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;

/**
 * Number of milliseconds since epoch.
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
public class Timestamp {
  Double value;
}
