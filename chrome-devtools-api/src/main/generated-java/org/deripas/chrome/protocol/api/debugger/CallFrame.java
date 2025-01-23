package org.deripas.chrome.protocol.api.debugger;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Boolean;
import java.lang.Deprecated;
import java.lang.String;
import java.util.List;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.runtime.RemoteObject;

/**
 * JavaScript call frame. Array of call frames form the call stack.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class CallFrame {
  /**
   * Call frame identifier. This identifier is only valid while the virtual machine is paused.
   */
  private final CallFrameId callFrameId;

  /**
   * Name of the JavaScript function called on this call frame.
   */
  private final String functionName;

  /**
   * Location in the source code.
   */
  @Nullable
  private final Location functionLocation;

  /**
   * Location in the source code.
   */
  private final Location location;

  /**
   * JavaScript script name or url.
   * Deprecated in favor of using the `location.scriptId` to resolve the URL via a previously
   * sent `Debugger.scriptParsed` event.
   */
  @Deprecated
  private final String url;

  /**
   * Scope chain for this call frame.
   */
  private final List<Scope> scopeChain;

  /**
   * `this` object for this call frame.
   */
  @JsonProperty("this")
  private final RemoteObject thisRef;

  /**
   * The value being returned, if the function is at return point.
   */
  @Nullable
  private final RemoteObject returnValue;

  /**
   * Valid only while the VM is paused and indicates whether this frame
   * can be restarted or not. Note that a `true` value here does not
   * guarantee that Debugger#restartFrame with this CallFrameId will be
   * successful, but it is very likely.
   */
  @Nullable
  @Experimental
  private final Boolean canBeRestarted;
}
