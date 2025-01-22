package org.deripas.chrome.protocol.api.domdebugger;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.dom.BackendNodeId;
import org.deripas.chrome.protocol.api.runtime.RemoteObject;
import org.deripas.chrome.protocol.api.runtime.ScriptId;

/**
 * Object event listener.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class EventListener {
  /**
   * `EventListener`'s type.
   */
  private final String type;

  /**
   * `EventListener`'s useCapture.
   */
  private final Boolean useCapture;

  /**
   * `EventListener`'s passive flag.
   */
  private final Boolean passive;

  /**
   * `EventListener`'s once flag.
   */
  private final Boolean once;

  /**
   * Script id of the handler code.
   */
  private final ScriptId scriptId;

  /**
   * Line number in the script (0-based).
   */
  private final Integer lineNumber;

  /**
   * Column number in the script (0-based).
   */
  private final Integer columnNumber;

  /**
   * Event handler function value.
   */
  @Nullable
  private final RemoteObject handler;

  /**
   * Event original handler function value.
   */
  @Nullable
  private final RemoteObject originalHandler;

  /**
   * Node the listener is added to (if any).
   */
  @Nullable
  private final BackendNodeId backendNodeId;
}
