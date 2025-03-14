package io.github.deripas.chrome.devtools.api.storage;

import io.github.deripas.chrome.devtools.api.Disposable;
import io.github.deripas.chrome.devtools.api.Session;
import io.github.deripas.chrome.devtools.api.browser.BrowserContextID;
import io.github.deripas.chrome.devtools.api.network.Cookie;
import io.github.deripas.chrome.devtools.api.network.CookieParam;
import io.github.deripas.chrome.devtools.api.network.RequestId;
import io.github.deripas.chrome.devtools.api.network.TimeSinceEpoch;
import io.github.deripas.chrome.devtools.api.page.FrameId;
import java.lang.Boolean;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import java.lang.Void;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Experimental
@Generated
public class Storage {
  private final Session session;

  /**
   * Returns a storage key given a frame id.
   */
  public CompletableFuture<GetStorageKeyForFrameResponse> getStorageKeyForFrame(
      GetStorageKeyForFrameRequest request) {
    return session.send("Storage.getStorageKeyForFrame", request, GetStorageKeyForFrameResponse.class);
  }

  /**
   * Clears storage for origin.
   */
  public CompletableFuture<Void> clearDataForOrigin(ClearDataForOriginRequest request) {
    return session.send("Storage.clearDataForOrigin", request, Void.class);
  }

  /**
   * Clears storage for storage key.
   */
  public CompletableFuture<Void> clearDataForStorageKey(ClearDataForStorageKeyRequest request) {
    return session.send("Storage.clearDataForStorageKey", request, Void.class);
  }

  /**
   * Returns all browser cookies.
   */
  public CompletableFuture<GetCookiesResponse> getCookies(GetCookiesRequest request) {
    return session.send("Storage.getCookies", request, GetCookiesResponse.class);
  }

  /**
   * Sets given cookies.
   */
  public CompletableFuture<Void> setCookies(SetCookiesRequest request) {
    return session.send("Storage.setCookies", request, Void.class);
  }

  /**
   * Clears cookies.
   */
  public CompletableFuture<Void> clearCookies(ClearCookiesRequest request) {
    return session.send("Storage.clearCookies", request, Void.class);
  }

  /**
   * Returns usage and quota in bytes.
   */
  public CompletableFuture<GetUsageAndQuotaResponse> getUsageAndQuota(
      GetUsageAndQuotaRequest request) {
    return session.send("Storage.getUsageAndQuota", request, GetUsageAndQuotaResponse.class);
  }

  /**
   * Override quota for the specified origin
   */
  public CompletableFuture<Void> overrideQuotaForOrigin(OverrideQuotaForOriginRequest request) {
    return session.send("Storage.overrideQuotaForOrigin", request, Void.class);
  }

  /**
   * Registers origin to be notified when an update occurs to its cache storage list.
   */
  public CompletableFuture<Void> trackCacheStorageForOrigin(
      TrackCacheStorageForOriginRequest request) {
    return session.send("Storage.trackCacheStorageForOrigin", request, Void.class);
  }

  /**
   * Registers storage key to be notified when an update occurs to its cache storage list.
   */
  public CompletableFuture<Void> trackCacheStorageForStorageKey(
      TrackCacheStorageForStorageKeyRequest request) {
    return session.send("Storage.trackCacheStorageForStorageKey", request, Void.class);
  }

  /**
   * Registers origin to be notified when an update occurs to its IndexedDB.
   */
  public CompletableFuture<Void> trackIndexedDBForOrigin(TrackIndexedDBForOriginRequest request) {
    return session.send("Storage.trackIndexedDBForOrigin", request, Void.class);
  }

  /**
   * Registers storage key to be notified when an update occurs to its IndexedDB.
   */
  public CompletableFuture<Void> trackIndexedDBForStorageKey(
      TrackIndexedDBForStorageKeyRequest request) {
    return session.send("Storage.trackIndexedDBForStorageKey", request, Void.class);
  }

  /**
   * Unregisters origin from receiving notifications for cache storage.
   */
  public CompletableFuture<Void> untrackCacheStorageForOrigin(
      UntrackCacheStorageForOriginRequest request) {
    return session.send("Storage.untrackCacheStorageForOrigin", request, Void.class);
  }

  /**
   * Unregisters storage key from receiving notifications for cache storage.
   */
  public CompletableFuture<Void> untrackCacheStorageForStorageKey(
      UntrackCacheStorageForStorageKeyRequest request) {
    return session.send("Storage.untrackCacheStorageForStorageKey", request, Void.class);
  }

  /**
   * Unregisters origin from receiving notifications for IndexedDB.
   */
  public CompletableFuture<Void> untrackIndexedDBForOrigin(
      UntrackIndexedDBForOriginRequest request) {
    return session.send("Storage.untrackIndexedDBForOrigin", request, Void.class);
  }

  /**
   * Unregisters storage key from receiving notifications for IndexedDB.
   */
  public CompletableFuture<Void> untrackIndexedDBForStorageKey(
      UntrackIndexedDBForStorageKeyRequest request) {
    return session.send("Storage.untrackIndexedDBForStorageKey", request, Void.class);
  }

  /**
   * Returns the number of stored Trust Tokens per issuer for the
   * current browsing context.
   */
  public CompletableFuture<GetTrustTokensResponse> getTrustTokens() {
    return session.send("Storage.getTrustTokens", null, GetTrustTokensResponse.class);
  }

  /**
   * Removes all Trust Tokens issued by the provided issuerOrigin.
   * Leaves other stored data, including the issuer's Redemption Records, intact.
   */
  public CompletableFuture<ClearTrustTokensResponse> clearTrustTokens(
      ClearTrustTokensRequest request) {
    return session.send("Storage.clearTrustTokens", request, ClearTrustTokensResponse.class);
  }

  /**
   * Gets details for a named interest group.
   */
  public CompletableFuture<GetInterestGroupDetailsResponse> getInterestGroupDetails(
      GetInterestGroupDetailsRequest request) {
    return session.send("Storage.getInterestGroupDetails", request, GetInterestGroupDetailsResponse.class);
  }

  /**
   * Enables/Disables issuing of interestGroupAccessed events.
   */
  public CompletableFuture<Void> setInterestGroupTracking(SetInterestGroupTrackingRequest request) {
    return session.send("Storage.setInterestGroupTracking", request, Void.class);
  }

  /**
   * Enables/Disables issuing of interestGroupAuctionEventOccurred and
   * interestGroupAuctionNetworkRequestCreated.
   */
  public CompletableFuture<Void> setInterestGroupAuctionTracking(
      SetInterestGroupAuctionTrackingRequest request) {
    return session.send("Storage.setInterestGroupAuctionTracking", request, Void.class);
  }

  /**
   * Gets metadata for an origin's shared storage.
   */
  public CompletableFuture<GetSharedStorageMetadataResponse> getSharedStorageMetadata(
      GetSharedStorageMetadataRequest request) {
    return session.send("Storage.getSharedStorageMetadata", request, GetSharedStorageMetadataResponse.class);
  }

  /**
   * Gets the entries in an given origin's shared storage.
   */
  public CompletableFuture<GetSharedStorageEntriesResponse> getSharedStorageEntries(
      GetSharedStorageEntriesRequest request) {
    return session.send("Storage.getSharedStorageEntries", request, GetSharedStorageEntriesResponse.class);
  }

  /**
   * Sets entry with `key` and `value` for a given origin's shared storage.
   */
  public CompletableFuture<Void> setSharedStorageEntry(SetSharedStorageEntryRequest request) {
    return session.send("Storage.setSharedStorageEntry", request, Void.class);
  }

  /**
   * Deletes entry for `key` (if it exists) for a given origin's shared storage.
   */
  public CompletableFuture<Void> deleteSharedStorageEntry(DeleteSharedStorageEntryRequest request) {
    return session.send("Storage.deleteSharedStorageEntry", request, Void.class);
  }

  /**
   * Clears all entries for a given origin's shared storage.
   */
  public CompletableFuture<Void> clearSharedStorageEntries(
      ClearSharedStorageEntriesRequest request) {
    return session.send("Storage.clearSharedStorageEntries", request, Void.class);
  }

  /**
   * Resets the budget for `ownerOrigin` by clearing all budget withdrawals.
   */
  public CompletableFuture<Void> resetSharedStorageBudget(ResetSharedStorageBudgetRequest request) {
    return session.send("Storage.resetSharedStorageBudget", request, Void.class);
  }

  /**
   * Enables/disables issuing of sharedStorageAccessed events.
   */
  public CompletableFuture<Void> setSharedStorageTracking(SetSharedStorageTrackingRequest request) {
    return session.send("Storage.setSharedStorageTracking", request, Void.class);
  }

  /**
   * Set tracking for a storage key's buckets.
   */
  public CompletableFuture<Void> setStorageBucketTracking(SetStorageBucketTrackingRequest request) {
    return session.send("Storage.setStorageBucketTracking", request, Void.class);
  }

  /**
   * Deletes the Storage Bucket with the given storage key and bucket name.
   */
  public CompletableFuture<Void> deleteStorageBucket(DeleteStorageBucketRequest request) {
    return session.send("Storage.deleteStorageBucket", request, Void.class);
  }

  /**
   * Deletes state for sites identified as potential bounce trackers, immediately.
   */
  public CompletableFuture<RunBounceTrackingMitigationsResponse> runBounceTrackingMitigations() {
    return session.send("Storage.runBounceTrackingMitigations", null, RunBounceTrackingMitigationsResponse.class);
  }

  /**
   * https://wicg.github.io/attribution-reporting-api/
   */
  public CompletableFuture<Void> setAttributionReportingLocalTestingMode(
      SetAttributionReportingLocalTestingModeRequest request) {
    return session.send("Storage.setAttributionReportingLocalTestingMode", request, Void.class);
  }

  /**
   * Enables/disables issuing of Attribution Reporting events.
   */
  public CompletableFuture<Void> setAttributionReportingTracking(
      SetAttributionReportingTrackingRequest request) {
    return session.send("Storage.setAttributionReportingTracking", request, Void.class);
  }

  /**
   * Sends all pending Attribution Reports immediately, regardless of their
   * scheduled report time.
   */
  public CompletableFuture<SendPendingAttributionReportsResponse> sendPendingAttributionReports() {
    return session.send("Storage.sendPendingAttributionReports", null, SendPendingAttributionReportsResponse.class);
  }

  /**
   * Returns the effective Related Website Sets in use by this profile for the browser
   * session. The effective Related Website Sets will not change during a browser session.
   */
  public CompletableFuture<GetRelatedWebsiteSetsResponse> getRelatedWebsiteSets() {
    return session.send("Storage.getRelatedWebsiteSets", null, GetRelatedWebsiteSetsResponse.class);
  }

  /**
   * Returns the list of URLs from a page and its embedded resources that match
   * existing grace period URL pattern rules.
   * https://developers.google.com/privacy-sandbox/cookies/temporary-exceptions/grace-period
   */
  public CompletableFuture<GetAffectedUrlsForThirdPartyCookieMetadataResponse> getAffectedUrlsForThirdPartyCookieMetadata(
      GetAffectedUrlsForThirdPartyCookieMetadataRequest request) {
    return session.send("Storage.getAffectedUrlsForThirdPartyCookieMetadata", request, GetAffectedUrlsForThirdPartyCookieMetadataResponse.class);
  }

  public Disposable onCacheStorageContentUpdated(
      Consumer<CacheStorageContentUpdatedEvent> listener) {
    return session.subscribe("Storage.cacheStorageContentUpdated", listener, CacheStorageContentUpdatedEvent.class);
  }

  public Disposable onCacheStorageListUpdated(Consumer<CacheStorageListUpdatedEvent> listener) {
    return session.subscribe("Storage.cacheStorageListUpdated", listener, CacheStorageListUpdatedEvent.class);
  }

  public Disposable onIndexedDBContentUpdated(Consumer<IndexedDBContentUpdatedEvent> listener) {
    return session.subscribe("Storage.indexedDBContentUpdated", listener, IndexedDBContentUpdatedEvent.class);
  }

  public Disposable onIndexedDBListUpdated(Consumer<IndexedDBListUpdatedEvent> listener) {
    return session.subscribe("Storage.indexedDBListUpdated", listener, IndexedDBListUpdatedEvent.class);
  }

  public Disposable onInterestGroupAccessed(Consumer<InterestGroupAccessedEvent> listener) {
    return session.subscribe("Storage.interestGroupAccessed", listener, InterestGroupAccessedEvent.class);
  }

  public Disposable onInterestGroupAuctionEventOccurred(
      Consumer<InterestGroupAuctionEventOccurredEvent> listener) {
    return session.subscribe("Storage.interestGroupAuctionEventOccurred", listener, InterestGroupAuctionEventOccurredEvent.class);
  }

  public Disposable onInterestGroupAuctionNetworkRequestCreated(
      Consumer<InterestGroupAuctionNetworkRequestCreatedEvent> listener) {
    return session.subscribe("Storage.interestGroupAuctionNetworkRequestCreated", listener, InterestGroupAuctionNetworkRequestCreatedEvent.class);
  }

  public Disposable onSharedStorageAccessed(Consumer<SharedStorageAccessedEvent> listener) {
    return session.subscribe("Storage.sharedStorageAccessed", listener, SharedStorageAccessedEvent.class);
  }

  public Disposable onStorageBucketCreatedOrUpdated(
      Consumer<StorageBucketCreatedOrUpdatedEvent> listener) {
    return session.subscribe("Storage.storageBucketCreatedOrUpdated", listener, StorageBucketCreatedOrUpdatedEvent.class);
  }

  public Disposable onStorageBucketDeleted(Consumer<StorageBucketDeletedEvent> listener) {
    return session.subscribe("Storage.storageBucketDeleted", listener, StorageBucketDeletedEvent.class);
  }

  public Disposable onAttributionReportingSourceRegistered(
      Consumer<AttributionReportingSourceRegisteredEvent> listener) {
    return session.subscribe("Storage.attributionReportingSourceRegistered", listener, AttributionReportingSourceRegisteredEvent.class);
  }

  public Disposable onAttributionReportingTriggerRegistered(
      Consumer<AttributionReportingTriggerRegisteredEvent> listener) {
    return session.subscribe("Storage.attributionReportingTriggerRegistered", listener, AttributionReportingTriggerRegisteredEvent.class);
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetStorageKeyForFrameRequest {
    private final FrameId frameId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetStorageKeyForFrameResponse {
    private final SerializedStorageKey storageKey;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class ClearDataForOriginRequest {
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
  public static class ClearDataForStorageKeyRequest {
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
  public static class GetCookiesRequest {
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
  public static class GetCookiesResponse {
    /**
     * Array of cookie objects.
     */
    private final List<Cookie> cookies;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetCookiesRequest {
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
  public static class ClearCookiesRequest {
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
  public static class GetUsageAndQuotaRequest {
    /**
     * Security origin.
     */
    private final String origin;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetUsageAndQuotaResponse {
    /**
     * Storage usage (bytes).
     */
    private final Double usage;

    /**
     * Storage quota (bytes).
     */
    private final Double quota;

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
  public static class OverrideQuotaForOriginRequest {
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
    private final Double quotaSize;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class TrackCacheStorageForOriginRequest {
    /**
     * Security origin.
     */
    private final String origin;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class TrackCacheStorageForStorageKeyRequest {
    /**
     * Storage key.
     */
    private final String storageKey;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class TrackIndexedDBForOriginRequest {
    /**
     * Security origin.
     */
    private final String origin;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class TrackIndexedDBForStorageKeyRequest {
    /**
     * Storage key.
     */
    private final String storageKey;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class UntrackCacheStorageForOriginRequest {
    /**
     * Security origin.
     */
    private final String origin;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class UntrackCacheStorageForStorageKeyRequest {
    /**
     * Storage key.
     */
    private final String storageKey;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class UntrackIndexedDBForOriginRequest {
    /**
     * Security origin.
     */
    private final String origin;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class UntrackIndexedDBForStorageKeyRequest {
    /**
     * Storage key.
     */
    private final String storageKey;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetTrustTokensResponse {
    private final List<TrustTokens> tokens;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class ClearTrustTokensRequest {
    private final String issuerOrigin;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class ClearTrustTokensResponse {
    /**
     * True if any tokens were deleted, false otherwise.
     */
    private final Boolean didDeleteTokens;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetInterestGroupDetailsRequest {
    private final String ownerOrigin;

    private final String name;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetInterestGroupDetailsResponse {
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
  public static class SetInterestGroupTrackingRequest {
    private final Boolean enable;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetInterestGroupAuctionTrackingRequest {
    private final Boolean enable;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetSharedStorageMetadataRequest {
    private final String ownerOrigin;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetSharedStorageMetadataResponse {
    private final SharedStorageMetadata metadata;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetSharedStorageEntriesRequest {
    private final String ownerOrigin;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetSharedStorageEntriesResponse {
    private final List<SharedStorageEntry> entries;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetSharedStorageEntryRequest {
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
  public static class DeleteSharedStorageEntryRequest {
    private final String ownerOrigin;

    private final String key;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class ClearSharedStorageEntriesRequest {
    private final String ownerOrigin;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class ResetSharedStorageBudgetRequest {
    private final String ownerOrigin;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetSharedStorageTrackingRequest {
    private final Boolean enable;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetStorageBucketTrackingRequest {
    private final String storageKey;

    private final Boolean enable;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class DeleteStorageBucketRequest {
    private final StorageBucket bucket;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class RunBounceTrackingMitigationsResponse {
    private final List<String> deletedSites;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetAttributionReportingLocalTestingModeRequest {
    /**
     * If enabled, noise is suppressed and reports are sent immediately.
     */
    private final Boolean enabled;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetAttributionReportingTrackingRequest {
    private final Boolean enable;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SendPendingAttributionReportsResponse {
    /**
     * The number of reports that were sent.
     */
    private final Integer numSent;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetRelatedWebsiteSetsResponse {
    private final List<RelatedWebsiteSet> sets;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetAffectedUrlsForThirdPartyCookieMetadataRequest {
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
  public static class GetAffectedUrlsForThirdPartyCookieMetadataResponse {
    /**
     * Array of matching URLs. If there is a primary pattern match for the first-
     * party URL, only the first-party URL is returned in the array.
     */
    private final List<String> matchedUrls;
  }

  /**
   * A cache's contents have been modified.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class CacheStorageContentUpdatedEvent {
    /**
     * Origin to update.
     */
    private final String origin;

    /**
     * Storage key to update.
     */
    private final String storageKey;

    /**
     * Storage bucket to update.
     */
    private final String bucketId;

    /**
     * Name of cache in origin.
     */
    private final String cacheName;
  }

  /**
   * A cache has been added/deleted.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class CacheStorageListUpdatedEvent {
    /**
     * Origin to update.
     */
    private final String origin;

    /**
     * Storage key to update.
     */
    private final String storageKey;

    /**
     * Storage bucket to update.
     */
    private final String bucketId;
  }

  /**
   * The origin's IndexedDB object store has been modified.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class IndexedDBContentUpdatedEvent {
    /**
     * Origin to update.
     */
    private final String origin;

    /**
     * Storage key to update.
     */
    private final String storageKey;

    /**
     * Storage bucket to update.
     */
    private final String bucketId;

    /**
     * Database to update.
     */
    private final String databaseName;

    /**
     * ObjectStore to update.
     */
    private final String objectStoreName;
  }

  /**
   * The origin's IndexedDB database list has been modified.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class IndexedDBListUpdatedEvent {
    /**
     * Origin to update.
     */
    private final String origin;

    /**
     * Storage key to update.
     */
    private final String storageKey;

    /**
     * Storage bucket to update.
     */
    private final String bucketId;
  }

  /**
   * One of the interest groups was accessed. Note that these events are global
   * to all targets sharing an interest group store.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class InterestGroupAccessedEvent {
    private final TimeSinceEpoch accessTime;

    private final InterestGroupAccessType type;

    private final String ownerOrigin;

    private final String name;

    /**
     * For topLevelBid/topLevelAdditionalBid, and when appropriate,
     * win and additionalBidWin
     */
    @Nullable
    private final String componentSellerOrigin;

    /**
     * For bid or somethingBid event, if done locally and not on a server.
     */
    @Nullable
    private final Double bid;

    @Nullable
    private final String bidCurrency;

    /**
     * For non-global events --- links to interestGroupAuctionEvent
     */
    @Nullable
    private final InterestGroupAuctionId uniqueAuctionId;
  }

  /**
   * An auction involving interest groups is taking place. These events are
   * target-specific.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class InterestGroupAuctionEventOccurredEvent {
    private final TimeSinceEpoch eventTime;

    private final InterestGroupAuctionEventType type;

    private final InterestGroupAuctionId uniqueAuctionId;

    /**
     * Set for child auctions.
     */
    @Nullable
    private final InterestGroupAuctionId parentAuctionId;

    /**
     * Set for started and configResolved
     */
    @Nullable
    private final Map auctionConfig;
  }

  /**
   * Specifies which auctions a particular network fetch may be related to, and
   * in what role. Note that it is not ordered with respect to
   * Network.requestWillBeSent (but will happen before loadingFinished
   * loadingFailed).
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class InterestGroupAuctionNetworkRequestCreatedEvent {
    private final InterestGroupAuctionFetchType type;

    private final RequestId requestId;

    /**
     * This is the set of the auctions using the worklet that issued this
     * request.  In the case of trusted signals, it's possible that only some of
     * them actually care about the keys being queried.
     */
    private final List<InterestGroupAuctionId> auctions;
  }

  /**
   * Shared storage was accessed by the associated page.
   * The following parameters are included in all events.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class SharedStorageAccessedEvent {
    /**
     * Time of the access.
     */
    private final TimeSinceEpoch accessTime;

    /**
     * Enum value indicating the Shared Storage API method invoked.
     */
    private final SharedStorageAccessType type;

    /**
     * DevTools Frame Token for the primary frame tree's root.
     */
    private final FrameId mainFrameId;

    /**
     * Serialized origin for the context that invoked the Shared Storage API.
     */
    private final String ownerOrigin;

    /**
     * The sub-parameters wrapped by `params` are all optional and their
     * presence/absence depends on `type`.
     */
    private final SharedStorageAccessParams params;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class StorageBucketCreatedOrUpdatedEvent {
    private final StorageBucketInfo bucketInfo;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class StorageBucketDeletedEvent {
    private final String bucketId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class AttributionReportingSourceRegisteredEvent {
    private final AttributionReportingSourceRegistration registration;

    private final AttributionReportingSourceRegistrationResult result;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class AttributionReportingTriggerRegisteredEvent {
    private final AttributionReportingTriggerRegistration registration;

    private final AttributionReportingEventLevelResult eventLevel;

    private final AttributionReportingAggregatableResult aggregatable;
  }
}
