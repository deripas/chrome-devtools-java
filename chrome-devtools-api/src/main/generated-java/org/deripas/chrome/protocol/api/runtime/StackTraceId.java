package org.deripas.chrome.protocol.api.runtime;

import java.lang.String;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * If `debuggerId` is set stack trace comes from another debugger and can be resolved there. This
 * allows to track cross-debugger calls. See `Runtime.StackTrace` and `Debugger.paused` for usages.
 */
@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class StackTraceId {
  private final String id;

  @Nullable
  private final UniqueDebuggerId debuggerId;
}
