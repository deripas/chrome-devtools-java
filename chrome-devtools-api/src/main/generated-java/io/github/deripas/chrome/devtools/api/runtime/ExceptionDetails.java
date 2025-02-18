package io.github.deripas.chrome.devtools.api.runtime;

import java.lang.Integer;
import java.lang.String;
import java.util.Map;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Detailed information about exception (or error) that was thrown during script compilation or
 * execution.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ExceptionDetails {
  /**
   * Exception id.
   */
  private final Integer exceptionId;

  /**
   * Exception text, which should be used together with exception object when available.
   */
  private final String text;

  /**
   * Line number of the exception location (0-based).
   */
  private final Integer lineNumber;

  /**
   * Column number of the exception location (0-based).
   */
  private final Integer columnNumber;

  /**
   * Script ID of the exception location.
   */
  @Nullable
  private final ScriptId scriptId;

  /**
   * URL of the exception location, to be used when the script was not reported.
   */
  @Nullable
  private final String url;

  /**
   * JavaScript stack trace if available.
   */
  @Nullable
  private final StackTrace stackTrace;

  /**
   * Exception object if available.
   */
  @Nullable
  private final RemoteObject exception;

  /**
   * Identifier of the context where exception happened.
   */
  @Nullable
  private final ExecutionContextId executionContextId;

  /**
   * Dictionary with entries of meta data that the client associated
   * with this exception, such as information about associated network
   * requests, etc.
   */
  @Nullable
  @Experimental
  private final Map exceptionMetaData;
}
