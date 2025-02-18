package io.github.deripas.chrome.devtools.api.audits;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

@Generated
public enum HeavyAdReason {
  @JsonProperty("NetworkTotalLimit")
  NETWORK_TOTAL_LIMIT,

  @JsonProperty("CpuTotalLimit")
  CPU_TOTAL_LIMIT,

  @JsonProperty("CpuPeakLimit")
  CPU_PEAK_LIMIT
}
