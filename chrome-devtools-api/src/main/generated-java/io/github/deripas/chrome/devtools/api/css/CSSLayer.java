package io.github.deripas.chrome.devtools.api.css;

import java.lang.String;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * CSS Layer at-rule descriptor.
 */
@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class CSSLayer {
  /**
   * Layer name.
   */
  private final String text;

  /**
   * The associated rule header range in the enclosing stylesheet (if
   * available).
   */
  @Nullable
  private final SourceRange range;

  /**
   * Identifier of the stylesheet containing this object (if exists).
   */
  @Nullable
  private final StyleSheetId styleSheetId;
}
