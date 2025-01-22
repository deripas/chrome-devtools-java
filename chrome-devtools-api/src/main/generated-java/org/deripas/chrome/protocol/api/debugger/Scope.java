package org.deripas.chrome.protocol.api.debugger;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.runtime.RemoteObject;

/**
 * Scope description.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class Scope {
  /**
   * Scope type.
   */
  private final Type type;

  /**
   * Object representing the scope. For `global` and `with` scopes it represents the actual
   * object; for the rest of the scopes, it is artificial transient object enumerating scope
   * variables as its properties.
   */
  private final RemoteObject object;

  @Nullable
  private final String name;

  /**
   * Location in the source code where scope starts
   */
  @Nullable
  private final Location startLocation;

  /**
   * Location in the source code where scope ends
   */
  @Nullable
  private final Location endLocation;

  public enum Type {
    @JsonProperty("global")
    GLOBAL,

    @JsonProperty("local")
    LOCAL,

    @JsonProperty("with")
    WITH,

    @JsonProperty("closure")
    CLOSURE,

    @JsonProperty("catch")
    CATCH,

    @JsonProperty("block")
    BLOCK,

    @JsonProperty("script")
    SCRIPT,

    @JsonProperty("eval")
    EVAL,

    @JsonProperty("module")
    MODULE,

    @JsonProperty("wasm-expression-stack")
    WASM_EXPRESSION_STACK
  }
}
