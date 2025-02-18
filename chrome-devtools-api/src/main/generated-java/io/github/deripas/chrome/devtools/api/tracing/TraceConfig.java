package io.github.deripas.chrome.devtools.api.tracing;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Boolean;
import java.lang.Double;
import java.lang.String;
import java.util.List;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class TraceConfig {
  /**
   * Controls how the trace buffer stores data.
   */
  @Nullable
  @Experimental
  private final RecordMode recordMode;

  /**
   * Size of the trace buffer in kilobytes. If not specified or zero is passed, a default value
   * of 200 MB would be used.
   */
  @Nullable
  @Experimental
  private final Double traceBufferSizeInKb;

  /**
   * Turns on JavaScript stack sampling.
   */
  @Nullable
  @Experimental
  private final Boolean enableSampling;

  /**
   * Turns on system tracing.
   */
  @Nullable
  @Experimental
  private final Boolean enableSystrace;

  /**
   * Turns on argument filter.
   */
  @Nullable
  @Experimental
  private final Boolean enableArgumentFilter;

  /**
   * Included category filters.
   */
  @Nullable
  private final List<String> includedCategories;

  /**
   * Excluded category filters.
   */
  @Nullable
  private final List<String> excludedCategories;

  /**
   * Configuration to synthesize the delays in tracing.
   */
  @Nullable
  @Experimental
  private final List<String> syntheticDelays;

  /**
   * Configuration for memory dump triggers. Used only when "memory-infra" category is enabled.
   */
  @Nullable
  @Experimental
  private final MemoryDumpConfig memoryDumpConfig;

  public enum RecordMode {
    @JsonProperty("recordUntilFull")
    RECORD_UNTIL_FULL,

    @JsonProperty("recordContinuously")
    RECORD_CONTINUOUSLY,

    @JsonProperty("recordAsMuchAsPossible")
    RECORD_AS_MUCH_AS_POSSIBLE,

    @JsonProperty("echoToConsole")
    ECHO_TO_CONSOLE
  }
}
