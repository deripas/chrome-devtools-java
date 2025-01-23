package org.deripas.chrome.protocol.api.indexeddb;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.String;
import java.util.List;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Key path.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class KeyPath {
  /**
   * Key path type.
   */
  private final Type type;

  /**
   * String value.
   */
  @Nullable
  private final String string;

  /**
   * Array value.
   */
  @Nullable
  private final List<String> array;

  public enum Type {
    @JsonProperty("null")
    NULL,

    @JsonProperty("string")
    STRING,

    @JsonProperty("array")
    ARRAY
  }
}
