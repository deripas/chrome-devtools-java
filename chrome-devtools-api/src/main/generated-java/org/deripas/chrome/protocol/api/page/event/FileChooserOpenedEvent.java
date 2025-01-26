package org.deripas.chrome.protocol.api.page.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.dom.BackendNodeId;
import org.deripas.chrome.protocol.api.page.FrameId;

/**
 * Emitted only when `page.interceptFileChooser` is enabled.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class FileChooserOpenedEvent {
  public static final EventId<FileChooserOpenedEvent> ID = new EventId<>("Page.fileChooserOpened", FileChooserOpenedEvent.class);

  /**
   * Id of the frame containing input node.
   */
  @Experimental
  private final FrameId frameId;

  /**
   * Input mode.
   */
  private final Mode mode;

  /**
   * Input node id. Only present for file choosers opened via an `<input type="file">` element.
   */
  @Nullable
  @Experimental
  private final BackendNodeId backendNodeId;

  public enum Mode {
    @JsonProperty("selectSingle")
    SELECT_SINGLE,

    @JsonProperty("selectMultiple")
    SELECT_MULTIPLE
  }
}
