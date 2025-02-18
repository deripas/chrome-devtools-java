package io.github.deripas.chrome.devtools.api.runtime;

import java.lang.String;
import java.util.List;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Call frames for assertions or error messages.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class StackTrace {
  /**
   * String label of this stack trace. For async traces this may be a name of the function that
   * initiated the async call.
   */
  @Nullable
  private final String description;

  /**
   * JavaScript function name.
   */
  private final List<CallFrame> callFrames;

  /**
   * Asynchronous JavaScript stack trace that preceded this stack, if available.
   */
  @Nullable
  private final StackTrace parent;

  /**
   * Asynchronous JavaScript stack trace that preceded this stack, if available.
   */
  @Nullable
  @Experimental
  private final StackTraceId parentId;
}
