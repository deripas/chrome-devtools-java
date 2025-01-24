package org.deripas.chrome.protocol.api.storage;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.lang.Void;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.browser.BrowserContextID;
import org.deripas.chrome.protocol.api.network.Cookie;
import org.deripas.chrome.protocol.api.network.CookieParam;
import org.deripas.chrome.protocol.api.page.FrameId;

@Experimental
@Generated
public interface Storage {
  /**
   * Returns a storage key given a frame id.
   */
  CompletableFuture<GetStorageKeyForFrameResponse> getStorageKeyForFrame(
      GetStorageKeyForFrameRequest request);

  /**
   * Clears storage for origin.
   */
  CompletableFuture<Void> clearDataForOrigin(ClearDataForOriginRequest request);

  /**
   * Clears storage for storage key.
   */
  CompletableFuture<Void> clearDataForStorageKey(ClearDataForStorageKeyRequest request);

  /**
   * Returns all browser cookies.
   */
  CompletableFuture<GetCookiesResponse> getCookies(GetCookiesRequest request);

  /**
   * Sets given cookies.
   */
  CompletableFuture<Void> setCookies(SetCookiesRequest request);

  /**
   * Clears cookies.
   */
  CompletableFuture<Void> clearCookies(ClearCookiesRequest request);

  /**
   * Returns usage and quota in bytes.
   */
  CompletableFuture<GetUsageAndQuotaResponse> getUsageAndQuota(GetUsageAndQuotaRequest request);

  /**
   * Override quota for the specified origin
   */
  CompletableFuture<Void> overrideQuotaForOrigin(OverrideQuotaForOriginRequest request);

  /**
   * Registers origin to be notified when an update occurs to its cache storage list.
   */
  CompletableFuture<Void> trackCacheStorageForOrigin(TrackCacheStorageForOriginRequest request);

  /**
   * Registers storage key to be notified when an update occurs to its cache storage list.
   */
  CompletableFuture<Void> trackCacheStorageForStorageKey(
      TrackCacheStorageForStorageKeyRequest request);

  /**
   * Registers origin to be notified when an update occurs to its IndexedDB.
   */
  CompletableFuture<Void> trackIndexedDBForOrigin(TrackIndexedDBForOriginRequest request);

  /**
   * Registers storage key to be notified when an update occurs to its IndexedDB.
   */
  CompletableFuture<Void> trackIndexedDBForStorageKey(TrackIndexedDBForStorageKeyRequest request);

  /**
   * Unregisters origin from receiving notifications for cache storage.
   */
  CompletableFuture<Void> untrackCacheStorageForOrigin(UntrackCacheStorageForOriginRequest request);

  /**
   * Unregisters storage key from receiving notifications for cache storage.
   */
  CompletableFuture<Void> untrackCacheStorageForStorageKey(
      UntrackCacheStorageForStorageKeyRequest request);

  /**
   * Unregisters origin from receiving notifications for IndexedDB.
   */
  CompletableFuture<Void> untrackIndexedDBForOrigin(UntrackIndexedDBForOriginRequest request);

  /**
   * Unregisters storage key from receiving notifications for IndexedDB.
   */
  CompletableFuture<Void> untrackIndexedDBForStorageKey(
      UntrackIndexedDBForStorageKeyRequest request);

  /**
   * Returns the number of stored Trust Tokens per issuer for the
   * current browsing context.
   */
  CompletableFuture<GetTrustTokensResponse> getTrustTokens();

  /**
   * Removes all Trust Tokens issued by the provided issuerOrigin.
   * Leaves other stored data, including the issuer's Redemption Records, intact.
   */
  CompletableFuture<ClearTrustTokensResponse> clearTrustTokens(ClearTrustTokensRequest request);

  /**
   * Gets details for a named interest group.
   */
  CompletableFuture<GetInterestGroupDetailsResponse> getInterestGroupDetails(
      GetInterestGroupDetailsRequest request);

  /**
   * Enables/Disables issuing of interestGroupAccessed events.
   */
  CompletableFuture<Void> setInterestGroupTracking(SetInterestGroupTrackingRequest request);

  /**
   * Enables/Disables issuing of interestGroupAuctionEventOccurred and
   * interestGroupAuctionNetworkRequestCreated.
   */
  CompletableFuture<Void> setInterestGroupAuctionTracking(
      SetInterestGroupAuctionTrackingRequest request);

  /**
   * Gets metadata for an origin's shared storage.
   */
  CompletableFuture<GetSharedStorageMetadataResponse> getSharedStorageMetadata(
      GetSharedStorageMetadataRequest request);

  /**
   * Gets the entries in an given origin's shared storage.
   */
  CompletableFuture<GetSharedStorageEntriesResponse> getSharedStorageEntries(
      GetSharedStorageEntriesRequest request);

  /**
   * Sets entry with `key` and `value` for a given origin's shared storage.
   */
  CompletableFuture<Void> setSharedStorageEntry(SetSharedStorageEntryRequest request);

  /**
   * Deletes entry for `key` (if it exists) for a given origin's shared storage.
   */
  CompletableFuture<Void> deleteSharedStorageEntry(DeleteSharedStorageEntryRequest request);

  /**
   * Clears all entries for a given origin's shared storage.
   */
  CompletableFuture<Void> clearSharedStorageEntries(ClearSharedStorageEntriesRequest request);

  /**
   * Resets the budget for `ownerOrigin` by clearing all budget withdrawals.
   */
  CompletableFuture<Void> resetSharedStorageBudget(ResetSharedStorageBudgetRequest request);

  /**
   * Enables/disables issuing of sharedStorageAccessed events.
   */
  CompletableFuture<Void> setSharedStorageTracking(SetSharedStorageTrackingRequest request);

  /**
   * Set tracking for a storage key's buckets.
   */
  CompletableFuture<Void> setStorageBucketTracking(SetStorageBucketTrackingRequest request);

  /**
   * Deletes the Storage Bucket with the given storage key and bucket name.
   */
  CompletableFuture<Void> deleteStorageBucket(DeleteStorageBucketRequest request);

  /**
   * Deletes state for sites identified as potential bounce trackers, immediately.
   */
  CompletableFuture<RunBounceTrackingMitigationsResponse> runBounceTrackingMitigations();

  /**
   * https://wicg.github.io/attribution-reporting-api/
   */
  CompletableFuture<Void> setAttributionReportingLocalTestingMode(
      SetAttributionReportingLocalTestingModeRequest request);

  /**
   * Enables/disables issuing of Attribution Reporting events.
   */
  CompletableFuture<Void> setAttributionReportingTracking(
      SetAttributionReportingTrackingRequest request);

  /**
   * Sends all pending Attribution Reports immediately, regardless of their
   * scheduled report time.
   */
  CompletableFuture<SendPendingAttributionReportsResponse> sendPendingAttributionReports();

  /**
   * Returns the effective Related Website Sets in use by this profile for the browser
   * session. The effective Related Website Sets will not change during a browser session.
   */
  CompletableFuture<GetRelatedWebsiteSetsResponse> getRelatedWebsiteSets();

  /**
   * Returns the list of URLs from a page and its embedded resources that match
   * existing grace period URL pattern rules.
   * https://developers.google.com/privacy-sandbox/cookies/temporary-exceptions/grace-period
   */
  CompletableFuture<GetAffectedUrlsForThirdPartyCookieMetadataResponse> getAffectedUrlsForThirdPartyCookieMetadata(
      GetAffectedUrlsForThirdPartyCookieMetadataRequest request);

  @Data
  @Builder(
      toBuilder = true
  )
  class GetStorageKeyForFrameRequest {
    private final FrameId frameId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetStorageKeyForFrameResponse {
    private final SerializedStorageKey storageKey;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class ClearDataForOriginRequest {
    /**
     * Security origin.
     */
    private final String origin;

    /**
     * Comma separated list of StorageType to clear.
     */
    private final String storageTypes;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class ClearDataForStorageKeyRequest {
    /**
     * Storage key.
     */
    private final String storageKey;

    /**
     * Comma separated list of StorageType to clear.
     */
    private final String storageTypes;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetCookiesRequest {
    /**
     * Browser context to use when called on the browser endpoint.
     */
    @Nullable
    private final BrowserContextID browserContextId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetCookiesResponse {
    /**
     * Array of cookie objects.
     */
    private final List<Cookie> cookies;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetCookiesRequest {
    /**
     * Cookies to be set.
     */
    private final List<CookieParam> cookies;

    /**
     * Browser context to use when called on the browser endpoint.
     */
    @Nullable
    private final BrowserContextID browserContextId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class ClearCookiesRequest {
    /**
     * Browser context to use when called on the browser endpoint.
     */
    @Nullable
    private final BrowserContextID browserContextId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetUsageAndQuotaRequest {
    /**
     * Security origin.
     */
    private final String origin;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetUsageAndQuotaResponse {
    /**
     * Storage usage (bytes).
     */
    private final Long usage;

    /**
     * Storage quota (bytes).
     */
    private final Long quota;

    /**
     * Whether or not the origin has an active storage quota override
     */
    private final Boolean overrideActive;

    /**
     * Storage usage per type (bytes).
     */
    private final List<UsageForType> usageBreakdown;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class OverrideQuotaForOriginRequest {
    /**
     * Security origin.
     */
    private final String origin;

    /**
     * The quota size (in bytes) to override the original quota with.
     * If this is called multiple times, the overridden quota will be equal to
     * the quotaSize provided in the final call. If this is called without
     * specifying a quotaSize, the quota will be reset to the default value for
     * the specified origin. If this is called multiple times with different
     * origins, the override will be maintained for each origin until it is
     * disabled (called without a quotaSize).
     */
    @Nullable
    private final Long quotaSize;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class TrackCacheStorageForOriginRequest {
    /**
     * Security origin.
     */
    private final String origin;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class TrackCacheStorageForStorageKeyRequest {
    /**
     * Storage key.
     */
    private final String storageKey;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class TrackIndexedDBForOriginRequest {
    /**
     * Security origin.
     */
    private final String origin;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class TrackIndexedDBForStorageKeyRequest {
    /**
     * Storage key.
     */
    private final String storageKey;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class UntrackCacheStorageForOriginRequest {
    /**
     * Security origin.
     */
    private final String origin;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class UntrackCacheStorageForStorageKeyRequest {
    /**
     * Storage key.
     */
    private final String storageKey;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class UntrackIndexedDBForOriginRequest {
    /**
     * Security origin.
     */
    private final String origin;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class UntrackIndexedDBForStorageKeyRequest {
    /**
     * Storage key.
     */
    private final String storageKey;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetTrustTokensResponse {
    private final List<TrustTokens> tokens;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class ClearTrustTokensRequest {
    private final String issuerOrigin;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class ClearTrustTokensResponse {
    /**
     * True if any tokens were deleted, false otherwise.
     */
    private final Boolean didDeleteTokens;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetInterestGroupDetailsRequest {
    private final String ownerOrigin;

    private final String name;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetInterestGroupDetailsResponse {
    /**
     * This largely corresponds to:
     * https://wicg.github.io/turtledove/#dictdef-generatebidinterestgroup
     * but has absolute expirationTime instead of relative lifetimeMs and
     * also adds joiningOrigin.
     */
    private final Map details;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetInterestGroupTrackingRequest {
    private final Boolean enable;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetInterestGroupAuctionTrackingRequest {
    private final Boolean enable;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetSharedStorageMetadataRequest {
    private final String ownerOrigin;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetSharedStorageMetadataResponse {
    private final SharedStorageMetadata metadata;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetSharedStorageEntriesRequest {
    private final String ownerOrigin;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetSharedStorageEntriesResponse {
    private final List<SharedStorageEntry> entries;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetSharedStorageEntryRequest {
    private final String ownerOrigin;

    private final String key;

    private final String value;

    /**
     * If `ignoreIfPresent` is included and true, then only sets the entry if
     * `key` doesn't already exist.
     */
    @Nullable
    private final Boolean ignoreIfPresent;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class DeleteSharedStorageEntryRequest {
    private final String ownerOrigin;

    private final String key;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class ClearSharedStorageEntriesRequest {
    private final String ownerOrigin;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class ResetSharedStorageBudgetRequest {
    private final String ownerOrigin;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetSharedStorageTrackingRequest {
    private final Boolean enable;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetStorageBucketTrackingRequest {
    private final String storageKey;

    private final Boolean enable;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class DeleteStorageBucketRequest {
    private final StorageBucket bucket;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class RunBounceTrackingMitigationsResponse {
    private final List<String> deletedSites;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetAttributionReportingLocalTestingModeRequest {
    /**
     * If enabled, noise is suppressed and reports are sent immediately.
     */
    private final Boolean enabled;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetAttributionReportingTrackingRequest {
    private final Boolean enable;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SendPendingAttributionReportsResponse {
    /**
     * The number of reports that were sent.
     */
    private final Integer numSent;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetRelatedWebsiteSetsResponse {
    private final List<RelatedWebsiteSet> sets;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetAffectedUrlsForThirdPartyCookieMetadataRequest {
    /**
     * The URL of the page currently being visited.
     */
    private final String firstPartyUrl;

    /**
     * The list of embedded resource URLs from the page.
     */
    private final List<String> thirdPartyUrls;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetAffectedUrlsForThirdPartyCookieMetadataResponse {
    /**
     * Array of matching URLs. If there is a primary pattern match for the first-
     * party URL, only the first-party URL is returned in the array.
     */
    private final List<String> matchedUrls;
  }
}
