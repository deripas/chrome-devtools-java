package org.deripas.chrome.protocol.api.security;

import java.lang.String;
import java.util.List;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * An explanation of an factor contributing to the security state.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class SecurityStateExplanation {
  /**
   * Security state representing the severity of the factor being explained.
   */
  private final SecurityState securityState;

  /**
   * Title describing the type of factor.
   */
  private final String title;

  /**
   * Short phrase describing the type of factor.
   */
  private final String summary;

  /**
   * Full text explanation of the factor.
   */
  private final String description;

  /**
   * The type of mixed content described by the explanation.
   */
  private final MixedContentType mixedContentType;

  /**
   * Page certificate.
   */
  private final List<String> certificate;

  /**
   * Recommendations to fix any issues.
   */
  @Nullable
  private final List<String> recommendations;
}
