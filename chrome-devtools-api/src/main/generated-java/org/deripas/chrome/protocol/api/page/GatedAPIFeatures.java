package org.deripas.chrome.protocol.api.page;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

@Experimental
@Generated
public enum GatedAPIFeatures {
  @JsonProperty("SharedArrayBuffers")
  SHARED_ARRAY_BUFFERS,

  @JsonProperty("SharedArrayBuffersTransferAllowed")
  SHARED_ARRAY_BUFFERS_TRANSFER_ALLOWED,

  @JsonProperty("PerformanceMeasureMemory")
  PERFORMANCE_MEASURE_MEMORY,

  @JsonProperty("PerformanceProfile")
  PERFORMANCE_PROFILE
}
