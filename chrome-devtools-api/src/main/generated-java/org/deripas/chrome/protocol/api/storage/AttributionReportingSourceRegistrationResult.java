package org.deripas.chrome.protocol.api.storage;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

@Experimental
@Generated
public enum AttributionReportingSourceRegistrationResult {
  @JsonProperty("success")
  SUCCESS,

  @JsonProperty("internalError")
  INTERNAL_ERROR,

  @JsonProperty("insufficientSourceCapacity")
  INSUFFICIENT_SOURCE_CAPACITY,

  @JsonProperty("insufficientUniqueDestinationCapacity")
  INSUFFICIENT_UNIQUE_DESTINATION_CAPACITY,

  @JsonProperty("excessiveReportingOrigins")
  EXCESSIVE_REPORTING_ORIGINS,

  @JsonProperty("prohibitedByBrowserPolicy")
  PROHIBITED_BY_BROWSER_POLICY,

  @JsonProperty("successNoised")
  SUCCESS_NOISED,

  @JsonProperty("destinationReportingLimitReached")
  DESTINATION_REPORTING_LIMIT_REACHED,

  @JsonProperty("destinationGlobalLimitReached")
  DESTINATION_GLOBAL_LIMIT_REACHED,

  @JsonProperty("destinationBothLimitsReached")
  DESTINATION_BOTH_LIMITS_REACHED,

  @JsonProperty("reportingOriginsPerSiteLimitReached")
  REPORTING_ORIGINS_PER_SITE_LIMIT_REACHED,

  @JsonProperty("exceedsMaxChannelCapacity")
  EXCEEDS_MAX_CHANNEL_CAPACITY,

  @JsonProperty("exceedsMaxScopesChannelCapacity")
  EXCEEDS_MAX_SCOPES_CHANNEL_CAPACITY,

  @JsonProperty("exceedsMaxTriggerStateCardinality")
  EXCEEDS_MAX_TRIGGER_STATE_CARDINALITY,

  @JsonProperty("exceedsMaxEventStatesLimit")
  EXCEEDS_MAX_EVENT_STATES_LIMIT,

  @JsonProperty("destinationPerDayReportingLimitReached")
  DESTINATION_PER_DAY_REPORTING_LIMIT_REACHED
}
