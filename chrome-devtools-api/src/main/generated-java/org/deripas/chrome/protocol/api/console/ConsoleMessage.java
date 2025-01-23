package org.deripas.chrome.protocol.api.console;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Integer;
import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Console message.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ConsoleMessage {
  /**
   * Message source.
   */
  private final Source source;

  /**
   * Message severity.
   */
  private final Level level;

  /**
   * Message text.
   */
  private final String text;

  /**
   * URL of the message origin.
   */
  @Nullable
  private final String url;

  /**
   * Line number in the resource that generated this message (1-based).
   */
  @Nullable
  private final Integer line;

  /**
   * Column number in the resource that generated this message (1-based).
   */
  @Nullable
  private final Integer column;

  public enum Source {
    @JsonProperty("xml")
    XML,

    @JsonProperty("javascript")
    JAVASCRIPT,

    @JsonProperty("network")
    NETWORK,

    @JsonProperty("console-api")
    CONSOLE_API,

    @JsonProperty("storage")
    STORAGE,

    @JsonProperty("appcache")
    APPCACHE,

    @JsonProperty("rendering")
    RENDERING,

    @JsonProperty("security")
    SECURITY,

    @JsonProperty("other")
    OTHER,

    @JsonProperty("deprecation")
    DEPRECATION,

    @JsonProperty("worker")
    WORKER
  }

  public enum Level {
    @JsonProperty("log")
    LOG,

    @JsonProperty("warning")
    WARNING,

    @JsonProperty("error")
    ERROR,

    @JsonProperty("debug")
    DEBUG,

    @JsonProperty("info")
    INFO
  }
}
