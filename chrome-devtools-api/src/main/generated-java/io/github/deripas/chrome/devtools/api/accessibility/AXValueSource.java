package io.github.deripas.chrome.devtools.api.accessibility;

import java.lang.Boolean;
import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * A single source for a computed AX property.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class AXValueSource {
  /**
   * What type of source this is.
   */
  private final AXValueSourceType type;

  /**
   * The value of this property source.
   */
  @Nullable
  private final AXValue value;

  /**
   * The name of the relevant attribute, if any.
   */
  @Nullable
  private final String attribute;

  /**
   * The value of the relevant attribute, if any.
   */
  @Nullable
  private final AXValue attributeValue;

  /**
   * Whether this source is superseded by a higher priority source.
   */
  @Nullable
  private final Boolean superseded;

  /**
   * The native markup source for this value, e.g. a `<label>` element.
   */
  @Nullable
  private final AXValueNativeSourceType nativeSource;

  /**
   * The value, such as a node or node list, of the native source.
   */
  @Nullable
  private final AXValue nativeSourceValue;

  /**
   * Whether the value for this property is invalid.
   */
  @Nullable
  private final Boolean invalid;

  /**
   * Reason for the value being invalid, if it is.
   */
  @Nullable
  private final String invalidReason;
}
