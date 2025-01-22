package org.deripas.chrome.protocol.api.domdebugger;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

/**
 * CSP Violation type.
 */
@Experimental
@Generated
public enum CSPViolationType {
  @JsonProperty("trustedtype-sink-violation")
  TRUSTEDTYPE_SINK_VIOLATION,

  @JsonProperty("trustedtype-policy-violation")
  TRUSTEDTYPE_POLICY_VIOLATION
}
