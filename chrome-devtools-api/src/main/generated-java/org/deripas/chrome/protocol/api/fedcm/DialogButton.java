package org.deripas.chrome.protocol.api.fedcm;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * The buttons on the FedCM dialog.
 */
@Generated
public enum DialogButton {
  @JsonProperty("ConfirmIdpLoginContinue")
  CONFIRM_IDP_LOGIN_CONTINUE,

  @JsonProperty("ErrorGotIt")
  ERROR_GOT_IT,

  @JsonProperty("ErrorMoreDetails")
  ERROR_MORE_DETAILS
}
