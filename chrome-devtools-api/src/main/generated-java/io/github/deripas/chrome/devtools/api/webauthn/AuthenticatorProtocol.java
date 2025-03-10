package io.github.deripas.chrome.devtools.api.webauthn;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

@Generated
public enum AuthenticatorProtocol {
  @JsonProperty("u2f")
  U2F,

  @JsonProperty("ctap2")
  CTAP2
}
