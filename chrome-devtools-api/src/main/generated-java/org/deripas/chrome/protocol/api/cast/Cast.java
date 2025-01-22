package org.deripas.chrome.protocol.api.cast;

import java.lang.String;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * A domain for interacting with Cast, Presentation API, and Remote Playback API
 * functionalities.
 */
@Experimental
@Generated
public interface Cast {
  /**
   * Starts observing for sinks that can be used for tab mirroring, and if set,
   * sinks compatible with |presentationUrl| as well. When sinks are found, a
   * |sinksUpdated| event is fired.
   * Also starts observing for issue messages. When an issue is added or removed,
   * an |issueUpdated| event is fired.
   */
  void enable(EnableRequest request);

  /**
   * Stops observing for sinks and issues.
   */
  void disable();

  /**
   * Sets a sink to be used when the web page requests the browser to choose a
   * sink via Presentation API, Remote Playback API, or Cast SDK.
   */
  void setSinkToUse(SetSinkToUseRequest request);

  /**
   * Starts mirroring the desktop to the sink.
   */
  void startDesktopMirroring(StartDesktopMirroringRequest request);

  /**
   * Starts mirroring the tab to the sink.
   */
  void startTabMirroring(StartTabMirroringRequest request);

  /**
   * Stops the active Cast session on the sink.
   */
  void stopCasting(StopCastingRequest request);

  @Data
  @Builder(
      toBuilder = true
  )
  class EnableRequest {
    @Nullable
    private final String presentationUrl;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetSinkToUseRequest {
    private final String sinkName;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class StartDesktopMirroringRequest {
    private final String sinkName;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class StartTabMirroringRequest {
    private final String sinkName;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class StopCastingRequest {
    private final String sinkName;
  }
}
