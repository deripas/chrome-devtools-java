package org.deripas.chrome.protocol.api.tracing;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

/**
 * Compression type to use for traces returned via streams.
 */
@Experimental
@Generated
public enum StreamCompression {
  @JsonProperty("none")
  NONE,

  @JsonProperty("gzip")
  GZIP
}
