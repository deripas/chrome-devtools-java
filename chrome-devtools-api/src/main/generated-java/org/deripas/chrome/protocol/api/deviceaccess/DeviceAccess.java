package org.deripas.chrome.protocol.api.deviceaccess;

import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Experimental
@Generated
public interface DeviceAccess {
  /**
   * Enable events in this domain.
   */
  void enable();

  /**
   * Disable events in this domain.
   */
  void disable();

  /**
   * Select a device in response to a DeviceAccess.deviceRequestPrompted event.
   */
  void selectPrompt(SelectPromptRequest request);

  /**
   * Cancel a prompt in response to a DeviceAccess.deviceRequestPrompted event.
   */
  void cancelPrompt(CancelPromptRequest request);

  @Data
  @Builder(
      toBuilder = true
  )
  class SelectPromptRequest {
    private final RequestId id;

    private final DeviceId deviceId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class CancelPromptRequest {
    private final RequestId id;
  }
}
