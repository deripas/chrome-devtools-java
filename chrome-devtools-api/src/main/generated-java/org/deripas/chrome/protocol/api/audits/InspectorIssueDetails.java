package org.deripas.chrome.protocol.api.audits;

import java.lang.Deprecated;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * This struct holds a list of optional fields with additional information
 * specific to the kind of issue. When adding a new issue code, please also
 * add a new optional field to this type.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class InspectorIssueDetails {
  @Nullable
  private final CookieIssueDetails cookieIssueDetails;

  @Nullable
  private final MixedContentIssueDetails mixedContentIssueDetails;

  @Nullable
  private final BlockedByResponseIssueDetails blockedByResponseIssueDetails;

  @Nullable
  private final HeavyAdIssueDetails heavyAdIssueDetails;

  @Nullable
  private final ContentSecurityPolicyIssueDetails contentSecurityPolicyIssueDetails;

  @Nullable
  private final SharedArrayBufferIssueDetails sharedArrayBufferIssueDetails;

  @Nullable
  private final LowTextContrastIssueDetails lowTextContrastIssueDetails;

  @Nullable
  private final CorsIssueDetails corsIssueDetails;

  @Nullable
  private final AttributionReportingIssueDetails attributionReportingIssueDetails;

  @Nullable
  private final QuirksModeIssueDetails quirksModeIssueDetails;

  @Nullable
  private final PartitioningBlobURLIssueDetails partitioningBlobURLIssueDetails;

  @Nullable
  @Deprecated
  private final NavigatorUserAgentIssueDetails navigatorUserAgentIssueDetails;

  @Nullable
  private final GenericIssueDetails genericIssueDetails;

  @Nullable
  private final DeprecationIssueDetails deprecationIssueDetails;

  @Nullable
  private final ClientHintIssueDetails clientHintIssueDetails;

  @Nullable
  private final FederatedAuthRequestIssueDetails federatedAuthRequestIssueDetails;

  @Nullable
  private final BounceTrackingIssueDetails bounceTrackingIssueDetails;

  @Nullable
  private final CookieDeprecationMetadataIssueDetails cookieDeprecationMetadataIssueDetails;

  @Nullable
  private final StylesheetLoadingIssueDetails stylesheetLoadingIssueDetails;

  @Nullable
  private final PropertyRuleIssueDetails propertyRuleIssueDetails;

  @Nullable
  private final FederatedAuthUserInfoRequestIssueDetails federatedAuthUserInfoRequestIssueDetails;

  @Nullable
  private final SharedDictionaryIssueDetails sharedDictionaryIssueDetails;

  @Nullable
  private final SelectElementAccessibilityIssueDetails selectElementAccessibilityIssueDetails;
}
