package org.deripas.chrome.protocol.api.storage;

import java.lang.Integer;
import java.lang.String;
import java.util.List;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.network.TimeSinceEpoch;

@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class AttributionReportingSourceRegistration {
  private final TimeSinceEpoch time;

  /**
   * duration in seconds
   */
  private final Integer expiry;

  private final List<AttributionReportingTriggerSpec> triggerSpecs;

  /**
   * duration in seconds
   */
  private final Integer aggregatableReportWindow;

  private final AttributionReportingSourceType type;

  private final String sourceOrigin;

  private final String reportingOrigin;

  private final List<String> destinationSites;

  private final UnsignedInt64AsBase10 eventId;

  private final SignedInt64AsBase10 priority;

  private final List<AttributionReportingFilterDataEntry> filterData;

  private final List<AttributionReportingAggregationKeysEntry> aggregationKeys;

  @Nullable
  private final UnsignedInt64AsBase10 debugKey;

  private final AttributionReportingTriggerDataMatching triggerDataMatching;

  private final SignedInt64AsBase10 destinationLimitPriority;

  private final AttributionReportingAggregatableDebugReportingConfig aggregatableDebugReportingConfig;

  @Nullable
  private final AttributionScopesData scopesData;

  private final Integer maxEventLevelReports;
}
