package org.deripas.chrome.protocol.api.audits;

import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class MixedContentIssueDetails {
  /**
   * The type of resource causing the mixed content issue (css, js, iframe,
   * form,...). Marked as optional because it is mapped to from
   * blink::mojom::RequestContextType, which will be replaced
   * by network::mojom::RequestDestination
   */
  @Nullable
  private final MixedContentResourceType resourceType;

  /**
   * The way the mixed content issue is being resolved.
   */
  private final MixedContentResolutionStatus resolutionStatus;

  /**
   * The unsafe http url causing the mixed content issue.
   */
  private final String insecureURL;

  /**
   * The url responsible for the call to an unsafe url.
   */
  private final String mainResourceURL;

  /**
   * The mixed content request.
   * Does not always exist (e.g. for unsafe form submission urls).
   */
  @Nullable
  private final AffectedRequest request;

  /**
   * Optional because not every mixed content issue is necessarily linked to a frame.
   */
  @Nullable
  private final AffectedFrame frame;
}
