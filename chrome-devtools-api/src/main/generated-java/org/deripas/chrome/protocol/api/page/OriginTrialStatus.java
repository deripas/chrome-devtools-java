package org.deripas.chrome.protocol.api.page;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

/**
 * Status for an Origin Trial.
 */
@Experimental
@Generated
public enum OriginTrialStatus {
  @JsonProperty("Enabled")
  ENABLED,

  @JsonProperty("ValidTokenNotProvided")
  VALID_TOKEN_NOT_PROVIDED,

  @JsonProperty("OSNotSupported")
  O_S_NOT_SUPPORTED,

  @JsonProperty("TrialNotAllowed")
  TRIAL_NOT_ALLOWED
}
