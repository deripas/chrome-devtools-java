package io.github.deripas.chrome.devtools.api.storage;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class AttributionReportingTriggerRegistration {
  private final AttributionReportingFilterPair filters;

  @Nullable
  private final UnsignedInt64AsBase10 debugKey;

  private final List<AttributionReportingAggregatableDedupKey> aggregatableDedupKeys;

  private final List<AttributionReportingEventTriggerData> eventTriggerData;

  private final List<AttributionReportingAggregatableTriggerData> aggregatableTriggerData;

  private final List<AttributionReportingAggregatableValueEntry> aggregatableValues;

  private final Integer aggregatableFilteringIdMaxBytes;

  private final Boolean debugReporting;

  @Nullable
  private final String aggregationCoordinatorOrigin;

  private final AttributionReportingSourceRegistrationTimeConfig sourceRegistrationTimeConfig;

  @Nullable
  private final String triggerContextId;

  private final AttributionReportingAggregatableDebugReportingConfig aggregatableDebugReportingConfig;

  private final List<String> scopes;
}
