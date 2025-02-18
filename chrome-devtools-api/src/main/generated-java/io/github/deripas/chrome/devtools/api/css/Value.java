package io.github.deripas.chrome.devtools.api.css;

import java.lang.String;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Data for a simple selector (these are delimited by commas in a selector list).
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class Value {
  /**
   * Value text.
   */
  private final String text;

  /**
   * Value range in the underlying resource (if available).
   */
  @Nullable
  private final SourceRange range;

  /**
   * Specificity of the selector.
   */
  @Nullable
  @Experimental
  private final Specificity specificity;
}
