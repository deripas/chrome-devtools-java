package org.deripas.chrome.protocol.api.runtime.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.String;
import java.util.List;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.runtime.ExecutionContextId;
import org.deripas.chrome.protocol.api.runtime.RemoteObject;
import org.deripas.chrome.protocol.api.runtime.StackTrace;
import org.deripas.chrome.protocol.api.runtime.Timestamp;

/**
 * Issued when console API was called.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ConsoleAPICalledEvent {
  public static final EventId<ConsoleAPICalledEvent> ID = new EventId<>("Runtime.consoleAPICalled", ConsoleAPICalledEvent.class);

  /**
   * Type of the call.
   */
  private final Type type;

  /**
   * Call arguments.
   */
  private final List<RemoteObject> args;

  /**
   * Identifier of the context where the call was made.
   */
  private final ExecutionContextId executionContextId;

  /**
   * Call timestamp.
   */
  private final Timestamp timestamp;

  /**
   * Stack trace captured when the call was made. The async stack chain is automatically reported for
   * the following call types: `assert`, `error`, `trace`, `warning`. For other types the async call
   * chain can be retrieved using `Debugger.getStackTrace` and `stackTrace.parentId` field.
   */
  @Nullable
  private final StackTrace stackTrace;

  /**
   * Console context descriptor for calls on non-default console context (not console.*):
   * 'anonymous#unique-logger-id' for call on unnamed context, 'name#unique-logger-id' for call
   * on named context.
   */
  @Nullable
  @Experimental
  private final String context;

  public enum Type {
    @JsonProperty("log")
    LOG,

    @JsonProperty("debug")
    DEBUG,

    @JsonProperty("info")
    INFO,

    @JsonProperty("error")
    ERROR,

    @JsonProperty("warning")
    WARNING,

    @JsonProperty("dir")
    DIR,

    @JsonProperty("dirxml")
    DIRXML,

    @JsonProperty("table")
    TABLE,

    @JsonProperty("trace")
    TRACE,

    @JsonProperty("clear")
    CLEAR,

    @JsonProperty("startGroup")
    START_GROUP,

    @JsonProperty("startGroupCollapsed")
    START_GROUP_COLLAPSED,

    @JsonProperty("endGroup")
    END_GROUP,

    @JsonProperty("assert")
    ASSERT,

    @JsonProperty("profile")
    PROFILE,

    @JsonProperty("profileEnd")
    PROFILE_END,

    @JsonProperty("count")
    COUNT,

    @JsonProperty("timeEnd")
    TIME_END
  }
}
