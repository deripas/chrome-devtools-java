package org.deripas.chrome.protocol.api.page.event;

import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.page.FrameId;

/**
 * Fired when page is about to start a download.
 * Deprecated. Use Browser.downloadWillBegin instead.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class DownloadWillBeginEvent {
  public static final EventId<DownloadWillBeginEvent> ID = new EventId<>("Page.downloadWillBegin", DownloadWillBeginEvent.class);

  /**
   * Id of the frame that caused download to begin.
   */
  private final FrameId frameId;

  /**
   * Global unique identifier of the download.
   */
  private final String guid;

  /**
   * URL of the resource being downloaded.
   */
  private final String url;

  /**
   * Suggested file name of the resource (the actual name of the file saved on disk may differ).
   */
  private final String suggestedFilename;
}
