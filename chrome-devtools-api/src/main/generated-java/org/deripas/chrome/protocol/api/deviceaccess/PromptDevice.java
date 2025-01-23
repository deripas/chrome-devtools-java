package org.deripas.chrome.protocol.api.deviceaccess;

import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Device information displayed in a user prompt to select a device.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class PromptDevice {
  private final DeviceId id;

  /**
   * Display name as it appears in a device request user prompt.
   */
  private final String name;
}
