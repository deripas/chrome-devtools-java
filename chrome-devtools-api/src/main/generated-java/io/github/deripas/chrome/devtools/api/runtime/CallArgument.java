package io.github.deripas.chrome.devtools.api.runtime;

import java.lang.Object;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Represents function call argument. Either remote object id `objectId`, primitive `value`,
 * unserializable primitive value or neither of (for undefined) them should be specified.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class CallArgument {
  /**
   * Primitive value or serializable javascript object.
   */
  @Nullable
  private final Object value;

  /**
   * Primitive value which can not be JSON-stringified.
   */
  @Nullable
  private final UnserializableValue unserializableValue;

  /**
   * Remote object handle.
   */
  @Nullable
  private final RemoteObjectId objectId;
}
