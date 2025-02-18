package io.github.deripas.chrome.devtools.api.tracing;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

/**
 * Backend type to use for tracing. `chrome` uses the Chrome-integrated
 * tracing service and is supported on all platforms. `system` is only
 * supported on Chrome OS and uses the Perfetto system tracing service.
 * `auto` chooses `system` when the perfettoConfig provided to Tracing.start
 * specifies at least one non-Chrome data source; otherwise uses `chrome`.
 */
@Experimental
@Generated
public enum TracingBackend {
  @JsonProperty("auto")
  AUTO,

  @JsonProperty("chrome")
  CHROME,

  @JsonProperty("system")
  SYSTEM
}
