package org.deripas.chrome.protocol.api.tracing;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Map;
import jdk.jfr.Experimental;
import lombok.Generated;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;

/**
 * Configuration for memory dump. Used only when "memory-infra" category is enabled.
 */
@Value
@RequiredArgsConstructor(
    staticName = "of",
    onConstructor_ = @JsonCreator
)
@Getter(
    onMethod_ = @JsonValue
)
@Experimental
@Generated
public class MemoryDumpConfig {
  Map value;
}
