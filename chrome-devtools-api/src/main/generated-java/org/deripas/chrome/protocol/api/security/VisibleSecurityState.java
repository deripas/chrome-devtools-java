package org.deripas.chrome.protocol.api.security;

import java.lang.String;
import java.util.List;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Security state information about the page.
 */
@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class VisibleSecurityState {
  /**
   * The security level of the page.
   */
  private final SecurityState securityState;

  /**
   * Security state details about the page certificate.
   */
  @Nullable
  private final CertificateSecurityState certificateSecurityState;

  /**
   * The type of Safety Tip triggered on the page. Note that this field will be set even if the Safety Tip UI was not actually shown.
   */
  @Nullable
  private final SafetyTipInfo safetyTipInfo;

  /**
   * Array of security state issues ids.
   */
  private final List<String> securityStateIssueIds;
}
