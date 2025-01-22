package org.deripas.chrome.protocol.api.runtime;

import java.lang.String;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Object private field descriptor.
 */
@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class PrivatePropertyDescriptor {
  /**
   * Private property name.
   */
  private final String name;

  /**
   * The value associated with the private property.
   */
  @Nullable
  private final RemoteObject value;

  /**
   * A function which serves as a getter for the private property,
   * or `undefined` if there is no getter (accessor descriptors only).
   */
  @Nullable
  private final RemoteObject get;

  /**
   * A function which serves as a setter for the private property,
   * or `undefined` if there is no setter (accessor descriptors only).
   */
  @Nullable
  private final RemoteObject set;
}
