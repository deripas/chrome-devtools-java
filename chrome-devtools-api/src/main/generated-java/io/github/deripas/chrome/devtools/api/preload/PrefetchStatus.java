package io.github.deripas.chrome.devtools.api.preload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * TODO(https://crbug.com/1384419): revisit the list of PrefetchStatus and
 * filter out the ones that aren't necessary to the developers.
 */
@Generated
public enum PrefetchStatus {
  @JsonProperty("PrefetchAllowed")
  PREFETCH_ALLOWED,

  @JsonProperty("PrefetchFailedIneligibleRedirect")
  PREFETCH_FAILED_INELIGIBLE_REDIRECT,

  @JsonProperty("PrefetchFailedInvalidRedirect")
  PREFETCH_FAILED_INVALID_REDIRECT,

  @JsonProperty("PrefetchFailedMIMENotSupported")
  PREFETCH_FAILED_M_I_M_E_NOT_SUPPORTED,

  @JsonProperty("PrefetchFailedNetError")
  PREFETCH_FAILED_NET_ERROR,

  @JsonProperty("PrefetchFailedNon2XX")
  PREFETCH_FAILED_NON2_X_X,

  @JsonProperty("PrefetchEvictedAfterCandidateRemoved")
  PREFETCH_EVICTED_AFTER_CANDIDATE_REMOVED,

  @JsonProperty("PrefetchEvictedForNewerPrefetch")
  PREFETCH_EVICTED_FOR_NEWER_PREFETCH,

  @JsonProperty("PrefetchHeldback")
  PREFETCH_HELDBACK,

  @JsonProperty("PrefetchIneligibleRetryAfter")
  PREFETCH_INELIGIBLE_RETRY_AFTER,

  @JsonProperty("PrefetchIsPrivacyDecoy")
  PREFETCH_IS_PRIVACY_DECOY,

  @JsonProperty("PrefetchIsStale")
  PREFETCH_IS_STALE,

  @JsonProperty("PrefetchNotEligibleBrowserContextOffTheRecord")
  PREFETCH_NOT_ELIGIBLE_BROWSER_CONTEXT_OFF_THE_RECORD,

  @JsonProperty("PrefetchNotEligibleDataSaverEnabled")
  PREFETCH_NOT_ELIGIBLE_DATA_SAVER_ENABLED,

  @JsonProperty("PrefetchNotEligibleExistingProxy")
  PREFETCH_NOT_ELIGIBLE_EXISTING_PROXY,

  @JsonProperty("PrefetchNotEligibleHostIsNonUnique")
  PREFETCH_NOT_ELIGIBLE_HOST_IS_NON_UNIQUE,

  @JsonProperty("PrefetchNotEligibleNonDefaultStoragePartition")
  PREFETCH_NOT_ELIGIBLE_NON_DEFAULT_STORAGE_PARTITION,

  @JsonProperty("PrefetchNotEligibleSameSiteCrossOriginPrefetchRequiredProxy")
  PREFETCH_NOT_ELIGIBLE_SAME_SITE_CROSS_ORIGIN_PREFETCH_REQUIRED_PROXY,

  @JsonProperty("PrefetchNotEligibleSchemeIsNotHttps")
  PREFETCH_NOT_ELIGIBLE_SCHEME_IS_NOT_HTTPS,

  @JsonProperty("PrefetchNotEligibleUserHasCookies")
  PREFETCH_NOT_ELIGIBLE_USER_HAS_COOKIES,

  @JsonProperty("PrefetchNotEligibleUserHasServiceWorker")
  PREFETCH_NOT_ELIGIBLE_USER_HAS_SERVICE_WORKER,

  @JsonProperty("PrefetchNotEligibleBatterySaverEnabled")
  PREFETCH_NOT_ELIGIBLE_BATTERY_SAVER_ENABLED,

  @JsonProperty("PrefetchNotEligiblePreloadingDisabled")
  PREFETCH_NOT_ELIGIBLE_PRELOADING_DISABLED,

  @JsonProperty("PrefetchNotFinishedInTime")
  PREFETCH_NOT_FINISHED_IN_TIME,

  @JsonProperty("PrefetchNotStarted")
  PREFETCH_NOT_STARTED,

  @JsonProperty("PrefetchNotUsedCookiesChanged")
  PREFETCH_NOT_USED_COOKIES_CHANGED,

  @JsonProperty("PrefetchProxyNotAvailable")
  PREFETCH_PROXY_NOT_AVAILABLE,

  @JsonProperty("PrefetchResponseUsed")
  PREFETCH_RESPONSE_USED,

  @JsonProperty("PrefetchSuccessfulButNotUsed")
  PREFETCH_SUCCESSFUL_BUT_NOT_USED,

  @JsonProperty("PrefetchNotUsedProbeFailed")
  PREFETCH_NOT_USED_PROBE_FAILED
}
