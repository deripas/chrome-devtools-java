package io.github.deripas.chrome.devtools.api.security;

import java.lang.Boolean;
import java.lang.Deprecated;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Information about insecure content on the page.
 */
@Data
@Builder(
    toBuilder = true
)
@Deprecated
@Generated
public class InsecureContentStatus {
  /**
   * Always false.
   */
  private final Boolean ranMixedContent;

  /**
   * Always false.
   */
  private final Boolean displayedMixedContent;

  /**
   * Always false.
   */
  private final Boolean containedMixedForm;

  /**
   * Always false.
   */
  private final Boolean ranContentWithCertErrors;

  /**
   * Always false.
   */
  private final Boolean displayedContentWithCertErrors;

  /**
   * Always set to unknown.
   */
  private final SecurityState ranInsecureContentStyle;

  /**
   * Always set to unknown.
   */
  private final SecurityState displayedInsecureContentStyle;
}
