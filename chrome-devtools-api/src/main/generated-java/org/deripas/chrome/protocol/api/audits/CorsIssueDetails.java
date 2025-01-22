package org.deripas.chrome.protocol.api.audits;

import java.lang.Boolean;
import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.network.ClientSecurityState;
import org.deripas.chrome.protocol.api.network.CorsErrorStatus;
import org.deripas.chrome.protocol.api.network.IPAddressSpace;

/**
 * Details for a CORS related issue, e.g. a warning or error related to
 * CORS RFC1918 enforcement.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class CorsIssueDetails {
  private final CorsErrorStatus corsErrorStatus;

  private final Boolean isWarning;

  private final AffectedRequest request;

  @Nullable
  private final SourceCodeLocation location;

  @Nullable
  private final String initiatorOrigin;

  @Nullable
  private final IPAddressSpace resourceIPAddressSpace;

  @Nullable
  private final ClientSecurityState clientSecurityState;
}
