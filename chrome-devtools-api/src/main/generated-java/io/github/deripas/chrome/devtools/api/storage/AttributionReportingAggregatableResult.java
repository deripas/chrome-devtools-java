package io.github.deripas.chrome.devtools.api.storage;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

@Experimental
@Generated
public enum AttributionReportingAggregatableResult {
  @JsonProperty("success")
  SUCCESS,

  @JsonProperty("internalError")
  INTERNAL_ERROR,

  @JsonProperty("noCapacityForAttributionDestination")
  NO_CAPACITY_FOR_ATTRIBUTION_DESTINATION,

  @JsonProperty("noMatchingSources")
  NO_MATCHING_SOURCES,

  @JsonProperty("excessiveAttributions")
  EXCESSIVE_ATTRIBUTIONS,

  @JsonProperty("excessiveReportingOrigins")
  EXCESSIVE_REPORTING_ORIGINS,

  @JsonProperty("noHistograms")
  NO_HISTOGRAMS,

  @JsonProperty("insufficientBudget")
  INSUFFICIENT_BUDGET,

  @JsonProperty("insufficientNamedBudget")
  INSUFFICIENT_NAMED_BUDGET,

  @JsonProperty("noMatchingSourceFilterData")
  NO_MATCHING_SOURCE_FILTER_DATA,

  @JsonProperty("notRegistered")
  NOT_REGISTERED,

  @JsonProperty("prohibitedByBrowserPolicy")
  PROHIBITED_BY_BROWSER_POLICY,

  @JsonProperty("deduplicated")
  DEDUPLICATED,

  @JsonProperty("reportWindowPassed")
  REPORT_WINDOW_PASSED,

  @JsonProperty("excessiveReports")
  EXCESSIVE_REPORTS
}
