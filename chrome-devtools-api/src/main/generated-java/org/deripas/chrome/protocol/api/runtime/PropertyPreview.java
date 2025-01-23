package org.deripas.chrome.protocol.api.runtime;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.String;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class PropertyPreview {
  /**
   * Property name.
   */
  private final String name;

  /**
   * Object type. Accessor means that the property itself is an accessor property.
   */
  private final Type type;

  /**
   * User-friendly property value string.
   */
  @Nullable
  private final String value;

  /**
   * Nested value preview.
   */
  @Nullable
  private final ObjectPreview valuePreview;

  /**
   * Object subtype hint. Specified for `object` type values only.
   */
  @Nullable
  private final Subtype subtype;

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

    @JsonProperty("accessor")
    ACCESSOR,

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
