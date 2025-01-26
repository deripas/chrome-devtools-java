package org.deripas.chrome.protocol.api.deviceaccess.event;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.deviceaccess.PromptDevice;
import org.deripas.chrome.protocol.api.deviceaccess.RequestId;

/**
 * A device request opened a user prompt to select a device. Respond with the
 * selectPrompt or cancelPrompt command.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class DeviceRequestPromptedEvent {
  public static final EventId<DeviceRequestPromptedEvent> ID = new EventId<>("DeviceAccess.deviceRequestPrompted", DeviceRequestPromptedEvent.class);

  private final RequestId id;

  private final List<PromptDevice> devices;
}
