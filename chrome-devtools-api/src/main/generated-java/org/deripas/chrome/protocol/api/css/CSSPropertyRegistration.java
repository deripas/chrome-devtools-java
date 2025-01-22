package org.deripas.chrome.protocol.api.css;

import java.lang.Boolean;
import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Representation of a custom property registration through CSS.registerProperty
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class CSSPropertyRegistration {
  private final String propertyName;

  @Nullable
  private final Value initialValue;

  private final Boolean inherits;

  private final String syntax;
}
