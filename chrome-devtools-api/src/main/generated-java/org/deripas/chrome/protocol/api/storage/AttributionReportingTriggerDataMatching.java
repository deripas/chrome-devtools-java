package org.deripas.chrome.protocol.api.storage;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

@Experimental
@Generated
public enum AttributionReportingTriggerDataMatching {
  @JsonProperty("exact")
  EXACT,

  @JsonProperty("modulus")
  MODULUS
}
