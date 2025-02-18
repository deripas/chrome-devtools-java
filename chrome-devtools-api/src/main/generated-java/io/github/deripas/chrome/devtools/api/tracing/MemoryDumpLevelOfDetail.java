package io.github.deripas.chrome.devtools.api.tracing;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

/**
 * Details exposed when memory request explicitly declared.
 * Keep consistent with memory_dump_request_args.h and
 * memory_instrumentation.mojom
 */
@Experimental
@Generated
public enum MemoryDumpLevelOfDetail {
  @JsonProperty("background")
  BACKGROUND,

  @JsonProperty("light")
  LIGHT,

  @JsonProperty("detailed")
  DETAILED
}
