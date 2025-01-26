package org.deripas.chrome.protocol.api.browser.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Long;
import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;

/**
 * Fired when download makes progress. Last call has |done| == true.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class DownloadProgressEvent {
  public static final EventId<DownloadProgressEvent> ID = new EventId<>("Browser.downloadProgress", DownloadProgressEvent.class);

  /**
   * Global unique identifier of the download.
   */
  private final String guid;

  /**
   * Total expected bytes to download.
   */
  private final Long totalBytes;

  /**
   * Total bytes received.
   */
  private final Long receivedBytes;

  /**
   * Download status.
   */
  private final State state;

  public enum State {
    @JsonProperty("inProgress")
    IN_PROGRESS,

    @JsonProperty("completed")
    COMPLETED,

    @JsonProperty("canceled")
    CANCELED
  }
}
