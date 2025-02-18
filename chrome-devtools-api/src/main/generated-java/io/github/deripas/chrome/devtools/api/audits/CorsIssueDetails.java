package io.github.deripas.chrome.devtools.api.audits;

import java.lang.Boolean;
import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import io.github.deripas.chrome.devtools.api.network.ClientSecurityState;
import io.github.deripas.chrome.devtools.api.network.CorsErrorStatus;
import io.github.deripas.chrome.devtools.api.network.IPAddressSpace;

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
