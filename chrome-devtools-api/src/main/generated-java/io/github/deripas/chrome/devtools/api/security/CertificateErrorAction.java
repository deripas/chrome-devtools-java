package io.github.deripas.chrome.devtools.api.security;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * The action to take when a certificate error occurs. continue will continue processing the
 * request and cancel will cancel the request.
 */
@Generated
public enum CertificateErrorAction {
  @JsonProperty("continue")
  CONTINUE,

  @JsonProperty("cancel")
  CANCEL
}
