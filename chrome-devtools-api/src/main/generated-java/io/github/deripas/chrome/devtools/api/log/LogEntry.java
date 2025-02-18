package io.github.deripas.chrome.devtools.api.log;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.deripas.chrome.devtools.api.network.RequestId;
import io.github.deripas.chrome.devtools.api.runtime.RemoteObject;
import io.github.deripas.chrome.devtools.api.runtime.StackTrace;
import io.github.deripas.chrome.devtools.api.runtime.Timestamp;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Log entry.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class LogEntry {
  /**
   * Log entry source.
   */
  private final Source source;

  /**
   * Log entry severity.
   */
  private final Level level;

  /**
   * Logged text.
   */
  private final String text;

  @Nullable
  private final Category category;

  /**
   * Timestamp when this entry was added.
   */
  private final Timestamp timestamp;

  /**
   * URL of the resource if known.
   */
  @Nullable
  private final String url;

  /**
   * Line number in the resource.
   */
  @Nullable
  private final Integer lineNumber;

  /**
   * JavaScript stack trace.
   */
  @Nullable
  private final StackTrace stackTrace;

  /**
   * Identifier of the network request associated with this entry.
   */
  @Nullable
  private final RequestId networkRequestId;

  /**
   * Identifier of the worker associated with this entry.
   */
  @Nullable
  private final String workerId;

  /**
   * Call arguments.
   */
  @Nullable
  private final List<RemoteObject> args;

  public enum Source {
    @JsonProperty("xml")
    XML,

    @JsonProperty("javascript")
    JAVASCRIPT,

    @JsonProperty("network")
    NETWORK,

    @JsonProperty("storage")
    STORAGE,

    @JsonProperty("appcache")
    APPCACHE,

    @JsonProperty("rendering")
    RENDERING,

    @JsonProperty("security")
    SECURITY,

    @JsonProperty("deprecation")
    DEPRECATION,

    @JsonProperty("worker")
    WORKER,

    @JsonProperty("violation")
    VIOLATION,

    @JsonProperty("intervention")
    INTERVENTION,

    @JsonProperty("recommendation")
    RECOMMENDATION,

    @JsonProperty("other")
    OTHER
  }

  public enum Level {
    @JsonProperty("verbose")
    VERBOSE,

    @JsonProperty("info")
    INFO,

    @JsonProperty("warning")
    WARNING,

    @JsonProperty("error")
    ERROR
  }

  public enum Category {
    @JsonProperty("cors")
    CORS
  }
}
