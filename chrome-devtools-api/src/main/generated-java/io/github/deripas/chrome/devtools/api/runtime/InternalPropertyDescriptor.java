package io.github.deripas.chrome.devtools.api.runtime;

import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Object internal property descriptor. This property isn't normally visible in JavaScript code.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class InternalPropertyDescriptor {
  /**
   * Conventional property name.
   */
  private final String name;

  /**
   * The value associated with the property.
   */
  @Nullable
  private final RemoteObject value;
}
