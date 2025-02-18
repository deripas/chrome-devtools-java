package io.github.deripas.chrome.devtools.api.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

/**
 * List of content encodings supported by the backend.
 */
@Experimental
@Generated
public enum ContentEncoding {
  @JsonProperty("deflate")
  DEFLATE,

  @JsonProperty("gzip")
  GZIP,

  @JsonProperty("br")
  BR,

  @JsonProperty("zstd")
  ZSTD
}
