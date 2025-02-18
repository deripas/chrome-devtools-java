package io.github.deripas.chrome.devtools.api.tracing;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

/**
 * Data format of a trace. Can be either the legacy JSON format or the
 * protocol buffer format. Note that the JSON format will be deprecated soon.
 */
@Experimental
@Generated
public enum StreamFormat {
  @JsonProperty("json")
  JSON,

  @JsonProperty("proto")
  PROTO
}
