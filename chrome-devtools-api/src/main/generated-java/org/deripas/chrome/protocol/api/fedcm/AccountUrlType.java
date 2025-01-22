package org.deripas.chrome.protocol.api.fedcm;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * The URLs that each account has
 */
@Generated
public enum AccountUrlType {
  @JsonProperty("TermsOfService")
  TERMS_OF_SERVICE,

  @JsonProperty("PrivacyPolicy")
  PRIVACY_POLICY
}
