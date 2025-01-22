package org.deripas.chrome.protocol.api.runtime;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Represents deep serialized value.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class DeepSerializedValue {
  private final Type type;

  @Nullable
  private final Object value;

  @Nullable
  private final String objectId;

  /**
   * Set if value reference met more then once during serialization. In such
   * case, value is provided only to one of the serialized values. Unique
   * per value in the scope of one CDP call.
   */
  @Nullable
  private final Integer weakLocalObjectReference;

  public enum Type {
    @JsonProperty("undefined")
    UNDEFINED,

    @JsonProperty("null")
    NULL,

    @JsonProperty("string")
    STRING,

    @JsonProperty("number")
    NUMBER,

    @JsonProperty("boolean")
    BOOLEAN,

    @JsonProperty("bigint")
    BIGINT,

    @JsonProperty("regexp")
    REGEXP,

    @JsonProperty("date")
    DATE,

    @JsonProperty("symbol")
    SYMBOL,

    @JsonProperty("array")
    ARRAY,

    @JsonProperty("object")
    OBJECT,

    @JsonProperty("function")
    FUNCTION,

    @JsonProperty("map")
    MAP,

    @JsonProperty("set")
    SET,

    @JsonProperty("weakmap")
    WEAKMAP,

    @JsonProperty("weakset")
    WEAKSET,

    @JsonProperty("error")
    ERROR,

    @JsonProperty("proxy")
    PROXY,

    @JsonProperty("promise")
    PROMISE,

    @JsonProperty("typedarray")
    TYPEDARRAY,

    @JsonProperty("arraybuffer")
    ARRAYBUFFER,

    @JsonProperty("node")
    NODE,

    @JsonProperty("window")
    WINDOW,

    @JsonProperty("generator")
    GENERATOR
  }
}
