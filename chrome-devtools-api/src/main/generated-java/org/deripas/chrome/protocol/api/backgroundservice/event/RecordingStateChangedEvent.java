package org.deripas.chrome.protocol.api.backgroundservice.event;

import java.lang.Boolean;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.backgroundservice.ServiceName;

/**
 * Called when the recording state for the service has been updated.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class RecordingStateChangedEvent {
  public static final EventId<RecordingStateChangedEvent> ID = new EventId<>("BackgroundService.recordingStateChanged", RecordingStateChangedEvent.class);

  private final Boolean isRecording;

  private final ServiceName service;
}
