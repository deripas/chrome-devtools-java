package io.github.deripas.chrome.devtools.api.fedcm;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * The types of FedCM dialogs.
 */
@Generated
public enum DialogType {
  @JsonProperty("AccountChooser")
  ACCOUNT_CHOOSER,

  @JsonProperty("AutoReauthn")
  AUTO_REAUTHN,

  @JsonProperty("ConfirmIdpLogin")
  CONFIRM_IDP_LOGIN,

  @JsonProperty("Error")
  ERROR
}
