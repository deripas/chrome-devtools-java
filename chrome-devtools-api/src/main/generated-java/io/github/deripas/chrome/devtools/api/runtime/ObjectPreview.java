package io.github.deripas.chrome.devtools.api.runtime;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Object containing abbreviated remote object value.
 */
@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class ObjectPreview {
  /**
   * Object type.
   */
  private final Type type;

  /**
   * Object subtype hint. Specified for `object` type values only.
   */
  @Nullable
  private final Subtype subtype;

  /**
   * String representation of the object.
   */
  @Nullable
  private final String description;

  /**
   * True iff some of the properties or entries of the original object did not fit.
   */
  private final Boolean overflow;

  /**
   * List of the properties.
   */
  private final List<PropertyPreview> properties;

  /**
   * List of the entries. Specified for `map` and `set` subtype values only.
   */
  @Nullable
  private final List<EntryPreview> entries;

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
