package io.github.deripas.chrome.devtools.api.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * Whether the request complied with Certificate Transparency policy.
 */
@Generated
public enum CertificateTransparencyCompliance {
  @JsonProperty("unknown")
  UNKNOWN,

  @JsonProperty("not-compliant")
  NOT_COMPLIANT,

  @JsonProperty("compliant")
  COMPLIANT
}
