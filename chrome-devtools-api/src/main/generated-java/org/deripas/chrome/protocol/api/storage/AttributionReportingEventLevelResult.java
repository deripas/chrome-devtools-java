package org.deripas.chrome.protocol.api.storage;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

@Experimental
@Generated
public enum AttributionReportingEventLevelResult {
  @JsonProperty("success")
  SUCCESS,

  @JsonProperty("successDroppedLowerPriority")
  SUCCESS_DROPPED_LOWER_PRIORITY,

  @JsonProperty("internalError")
  INTERNAL_ERROR,

  @JsonProperty("noCapacityForAttributionDestination")
  NO_CAPACITY_FOR_ATTRIBUTION_DESTINATION,

  @JsonProperty("noMatchingSources")
  NO_MATCHING_SOURCES,

  @JsonProperty("deduplicated")
  DEDUPLICATED,

  @JsonProperty("excessiveAttributions")
  EXCESSIVE_ATTRIBUTIONS,

  @JsonProperty("priorityTooLow")
  PRIORITY_TOO_LOW,

  @JsonProperty("neverAttributedSource")
  NEVER_ATTRIBUTED_SOURCE,

  @JsonProperty("excessiveReportingOrigins")
  EXCESSIVE_REPORTING_ORIGINS,

  @JsonProperty("noMatchingSourceFilterData")
  NO_MATCHING_SOURCE_FILTER_DATA,

  @JsonProperty("prohibitedByBrowserPolicy")
  PROHIBITED_BY_BROWSER_POLICY,

  @JsonProperty("noMatchingConfigurations")
  NO_MATCHING_CONFIGURATIONS,

  @JsonProperty("excessiveReports")
  EXCESSIVE_REPORTS,

  @JsonProperty("falselyAttributedSource")
  FALSELY_ATTRIBUTED_SOURCE,

  @JsonProperty("reportWindowPassed")
  REPORT_WINDOW_PASSED,

  @JsonProperty("notRegistered")
  NOT_REGISTERED,

  @JsonProperty("reportWindowNotStarted")
  REPORT_WINDOW_NOT_STARTED,

  @JsonProperty("noMatchingTriggerData")
  NO_MATCHING_TRIGGER_DATA
}
