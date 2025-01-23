package org.deripas.chrome.protocol.api.css;

import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * CSS property declaration data.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class CSSProperty {
  /**
   * The property name.
   */
  private final String name;

  /**
   * The property value.
   */
  private final String value;

  /**
   * Whether the property has "!important" annotation (implies `false` if absent).
   */
  @Nullable
  private final Boolean important;

  /**
   * Whether the property is implicit (implies `false` if absent).
   */
  @Nullable
  private final Boolean implicit;

  /**
   * The full property text as specified in the style.
   */
  @Nullable
  private final String text;

  /**
   * Whether the property is understood by the browser (implies `true` if absent).
   */
  @Nullable
  private final Boolean parsedOk;

  /**
   * Whether the property is disabled by the user (present for source-based properties only).
   */
  @Nullable
  private final Boolean disabled;

  /**
   * The entire property range in the enclosing style declaration (if available).
   */
  @Nullable
  private final SourceRange range;

  /**
   * Parsed longhand components of this property if it is a shorthand.
   * This field will be empty if the given property is not a shorthand.
   */
  @Nullable
  @Experimental
  private final List<CSSProperty> longhandProperties;
}
