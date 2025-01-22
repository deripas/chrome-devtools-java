package org.deripas.chrome.protocol.api.runtime;

import java.lang.Boolean;
import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Object property descriptor.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class PropertyDescriptor {
  /**
   * Property name or symbol description.
   */
  private final String name;

  /**
   * The value associated with the property.
   */
  @Nullable
  private final RemoteObject value;

  /**
   * True if the value associated with the property may be changed (data descriptors only).
   */
  @Nullable
  private final Boolean writable;

  /**
   * A function which serves as a getter for the property, or `undefined` if there is no getter
   * (accessor descriptors only).
   */
  @Nullable
  private final RemoteObject get;

  /**
   * A function which serves as a setter for the property, or `undefined` if there is no setter
   * (accessor descriptors only).
   */
  @Nullable
  private final RemoteObject set;

  /**
   * True if the type of this property descriptor may be changed and if the property may be
   * deleted from the corresponding object.
   */
  private final Boolean configurable;

  /**
   * True if this property shows up during enumeration of the properties on the corresponding
   * object.
   */
  private final Boolean enumerable;

  /**
   * True if the result was thrown during the evaluation.
   */
  @Nullable
  private final Boolean wasThrown;

  /**
   * True if the property is owned for the object.
   */
  @Nullable
  private final Boolean isOwn;

  /**
   * Property symbol object, if the property is of the `symbol` type.
   */
  @Nullable
  private final RemoteObject symbol;
}
