package io.github.deripas.chrome.devtools.api.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

/**
 * Types of reasons why a cookie may not be stored from a response.
 */
@Experimental
@Generated
public enum SetCookieBlockedReason {
  @JsonProperty("SecureOnly")
  SECURE_ONLY,

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

  @JsonProperty("SyntaxError")
  SYNTAX_ERROR,

  @JsonProperty("SchemeNotSupported")
  SCHEME_NOT_SUPPORTED,

  @JsonProperty("OverwriteSecure")
  OVERWRITE_SECURE,

  @JsonProperty("InvalidDomain")
  INVALID_DOMAIN,

  @JsonProperty("InvalidPrefix")
  INVALID_PREFIX,

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

  @JsonProperty("SamePartyConflictsWithOtherAttributes")
  SAME_PARTY_CONFLICTS_WITH_OTHER_ATTRIBUTES,

  @JsonProperty("NameValuePairExceedsMaxSize")
  NAME_VALUE_PAIR_EXCEEDS_MAX_SIZE,

  @JsonProperty("DisallowedCharacter")
  DISALLOWED_CHARACTER,

  @JsonProperty("NoCookieContent")
  NO_COOKIE_CONTENT
}
