package io.github.deripas.chrome.devtools.api.page;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

/**
 * Indicates whether the frame is a secure context and why it is the case.
 */
@Experimental
@Generated
public enum SecureContextType {
  @JsonProperty("Secure")
  SECURE,

  @JsonProperty("SecureLocalhost")
  SECURE_LOCALHOST,

  @JsonProperty("InsecureScheme")
  INSECURE_SCHEME,

  @JsonProperty("InsecureAncestor")
  INSECURE_ANCESTOR
}
