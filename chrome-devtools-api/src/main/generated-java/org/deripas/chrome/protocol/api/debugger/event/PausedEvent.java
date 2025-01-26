package org.deripas.chrome.protocol.api.debugger.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Deprecated;
import java.lang.String;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.debugger.CallFrame;
import org.deripas.chrome.protocol.api.runtime.StackTrace;
import org.deripas.chrome.protocol.api.runtime.StackTraceId;

/**
 * Fired when the virtual machine stopped on breakpoint or exception or any other stop criteria.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class PausedEvent {
  public static final EventId<PausedEvent> ID = new EventId<>("Debugger.paused", PausedEvent.class);

  /**
   * Call stack the virtual machine stopped on.
   */
  private final List<CallFrame> callFrames;

  /**
   * Pause reason.
   */
  private final Reason reason;

  /**
   * Object containing break-specific auxiliary properties.
   */
  @Nullable
  private final Map data;

  /**
   * Hit breakpoints IDs
   */
  @Nullable
  private final List<String> hitBreakpoints;

  /**
   * Async stack trace, if any.
   */
  @Nullable
  private final StackTrace asyncStackTrace;

  /**
   * Async stack trace, if any.
   */
  @Nullable
  @Experimental
  private final StackTraceId asyncStackTraceId;

  /**
   * Never present, will be removed.
   */
  @Nullable
  @Experimental
  @Deprecated
  private final StackTraceId asyncCallStackTraceId;

  public enum Reason {
    @JsonProperty("ambiguous")
    AMBIGUOUS,

    @JsonProperty("assert")
    ASSERT,

    @JsonProperty("CSPViolation")
    C_S_P_VIOLATION,

    @JsonProperty("debugCommand")
    DEBUG_COMMAND,

    @JsonProperty("DOM")
    D_O_M,

    @JsonProperty("EventListener")
    EVENT_LISTENER,

    @JsonProperty("exception")
    EXCEPTION,

    @JsonProperty("instrumentation")
    INSTRUMENTATION,

    @JsonProperty("OOM")
    O_O_M,

    @JsonProperty("other")
    OTHER,

    @JsonProperty("promiseRejection")
    PROMISE_REJECTION,

    @JsonProperty("XHR")
    X_H_R,

    @JsonProperty("step")
    STEP
  }
}
