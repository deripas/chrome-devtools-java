package org.deripas.chrome.protocol.api.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

/**
 * Types of reasons why a cookie may not be sent with a request.
 */
@Experimental
@Generated
public enum CookieBlockedReason {
  @JsonProperty("SecureOnly")
  SECURE_ONLY,

  @JsonProperty("NotOnPath")
  NOT_ON_PATH,

  @JsonProperty("DomainMismatch")
  DOMAIN_MISMATCH,

  @JsonProperty("SameSiteStrict")
  SAME_SITE_STRICT,

  @JsonProperty("SameSiteLax")
  SAME_SITE_LAX,

  @JsonProperty("SameSiteUnspecifiedTreatedAsLax")
  SAME_SITE_UNSPECIFIED_TREATED_AS_LAX,

  @JsonProperty("SameSiteNoneInsecure")
  SAME_SITE_NONE_INSECURE,

  @JsonProperty("UserPreferences")
  USER_PREFERENCES,

  @JsonProperty("ThirdPartyPhaseout")
  THIRD_PARTY_PHASEOUT,

  @JsonProperty("ThirdPartyBlockedInFirstPartySet")
  THIRD_PARTY_BLOCKED_IN_FIRST_PARTY_SET,

  @JsonProperty("UnknownError")
  UNKNOWN_ERROR,

  @JsonProperty("SchemefulSameSiteStrict")
  SCHEMEFUL_SAME_SITE_STRICT,

  @JsonProperty("SchemefulSameSiteLax")
  SCHEMEFUL_SAME_SITE_LAX,

  @JsonProperty("SchemefulSameSiteUnspecifiedTreatedAsLax")
  SCHEMEFUL_SAME_SITE_UNSPECIFIED_TREATED_AS_LAX,

  @JsonProperty("SamePartyFromCrossPartyContext")
  SAME_PARTY_FROM_CROSS_PARTY_CONTEXT,

  @JsonProperty("NameValuePairExceedsMaxSize")
  NAME_VALUE_PAIR_EXCEEDS_MAX_SIZE,

  @JsonProperty("PortMismatch")
  PORT_MISMATCH,

  @JsonProperty("SchemeMismatch")
  SCHEME_MISMATCH
}
