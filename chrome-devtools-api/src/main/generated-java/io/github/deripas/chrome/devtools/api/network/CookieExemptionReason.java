package io.github.deripas.chrome.devtools.api.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

/**
 * Types of reasons why a cookie should have been blocked by 3PCD but is exempted for the request.
 */
@Experimental
@Generated
public enum CookieExemptionReason {
  @JsonProperty("None")
  NONE,

  @JsonProperty("UserSetting")
  USER_SETTING,

  @JsonProperty("TPCDMetadata")
  T_P_C_D_METADATA,

  @JsonProperty("TPCDDeprecationTrial")
  T_P_C_D_DEPRECATION_TRIAL,

  @JsonProperty("TopLevelTPCDDeprecationTrial")
  TOP_LEVEL_T_P_C_D_DEPRECATION_TRIAL,

  @JsonProperty("TPCDHeuristics")
  T_P_C_D_HEURISTICS,

  @JsonProperty("EnterprisePolicy")
  ENTERPRISE_POLICY,

  @JsonProperty("StorageAccess")
  STORAGE_ACCESS,

  @JsonProperty("TopLevelStorageAccess")
  TOP_LEVEL_STORAGE_ACCESS,

  @JsonProperty("Scheme")
  SCHEME,

  @JsonProperty("SameSiteNoneCookiesInSandbox")
  SAME_SITE_NONE_COOKIES_IN_SANDBOX
}
