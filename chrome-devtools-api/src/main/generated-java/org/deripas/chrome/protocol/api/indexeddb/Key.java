package org.deripas.chrome.protocol.api.indexeddb;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Double;
import java.lang.String;
import java.util.List;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Key.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class Key {
  /**
   * Key type.
   */
  private final Type type;

  /**
   * Number value.
   */
  @Nullable
  private final Double number;

  /**
   * String value.
   */
  @Nullable
  private final String string;

  /**
   * Date value.
   */
  @Nullable
  private final Double date;

  /**
   * Array value.
   */
  @Nullable
  private final List<Key> array;

  public enum Type {
    @JsonProperty("number")
    NUMBER,

    @JsonProperty("string")
    STRING,

    @JsonProperty("date")
    DATE,

    @JsonProperty("array")
    ARRAY
  }
}
