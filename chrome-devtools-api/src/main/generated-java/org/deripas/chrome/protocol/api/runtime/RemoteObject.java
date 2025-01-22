package org.deripas.chrome.protocol.api.runtime;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Object;
import java.lang.String;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Mirror object referencing original JavaScript object.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class RemoteObject {
  /**
   * Object type.
   */
  private final Type type;

  /**
   * Object subtype hint. Specified for `object` type values only.
   * NOTE: If you change anything here, make sure to also update
   * `subtype` in `ObjectPreview` and `PropertyPreview` below.
   */
  @Nullable
  private final Subtype subtype;

  /**
   * Object class (constructor) name. Specified for `object` type values only.
   */
  @Nullable
  private final String className;

  /**
   * Remote object value in case of primitive values or JSON values (if it was requested).
   */
  @Nullable
  private final Object value;

  /**
   * Primitive value which can not be JSON-stringified does not have `value`, but gets this
   * property.
   */
  @Nullable
  private final UnserializableValue unserializableValue;

  /**
   * String representation of the object.
   */
  @Nullable
  private final String description;

  /**
   * Deep serialized value.
   */
  @Nullable
  @Experimental
  private final DeepSerializedValue deepSerializedValue;

  /**
   * Unique object identifier (for non-primitive values).
   */
  @Nullable
  private final RemoteObjectId objectId;

  /**
   * Preview containing abbreviated property values. Specified for `object` type values only.
   */
  @Nullable
  @Experimental
  private final ObjectPreview preview;

  @Nullable
  @Experimental
  private final CustomPreview customPreview;

  public enum Type {
    @JsonProperty("object")
    OBJECT,

    @JsonProperty("function")
    FUNCTION,

    @JsonProperty("undefined")
    UNDEFINED,

    @JsonProperty("string")
    STRING,

    @JsonProperty("number")
    NUMBER,

    @JsonProperty("boolean")
    BOOLEAN,

    @JsonProperty("symbol")
    SYMBOL,

    @JsonProperty("bigint")
    BIGINT
  }

  public enum Subtype {
    @JsonProperty("array")
    ARRAY,

    @JsonProperty("null")
    NULL,

    @JsonProperty("node")
    NODE,

    @JsonProperty("regexp")
    REGEXP,

    @JsonProperty("date")
    DATE,

    @JsonProperty("map")
    MAP,

    @JsonProperty("set")
    SET,

    @JsonProperty("weakmap")
    WEAKMAP,

    @JsonProperty("weakset")
    WEAKSET,

    @JsonProperty("iterator")
    ITERATOR,

    @JsonProperty("generator")
    GENERATOR,

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

    @JsonProperty("dataview")
    DATAVIEW,

    @JsonProperty("webassemblymemory")
    WEBASSEMBLYMEMORY,

    @JsonProperty("wasmvalue")
    WASMVALUE
  }
}
