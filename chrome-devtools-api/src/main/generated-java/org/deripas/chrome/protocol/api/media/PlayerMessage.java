package org.deripas.chrome.protocol.api.media;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Have one type per entry in MediaLogRecord::Type
 * Corresponds to kMessage
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class PlayerMessage {
  /**
   * Keep in sync with MediaLogMessageLevel
   * We are currently keeping the message level 'error' separate from the
   * PlayerError type because right now they represent different things,
   * this one being a DVLOG(ERROR) style log message that gets printed
   * based on what log level is selected in the UI, and the other is a
   * representation of a media::PipelineStatus object. Soon however we're
   * going to be moving away from using PipelineStatus for errors and
   * introducing a new error type which should hopefully let us integrate
   * the error log level into the PlayerError type.
   */
  private final Level level;

  private final String message;

  public enum Level {
    @JsonProperty("error")
    ERROR,

    @JsonProperty("warning")
    WARNING,

    @JsonProperty("info")
    INFO,

    @JsonProperty("debug")
    DEBUG
  }
}
