package org.deripas.chrome.protocol.api.deviceaccess;

import java.lang.Void;
import java.util.concurrent.CompletableFuture;
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
  CompletableFuture<Void> enable();

  /**
   * Disable events in this domain.
   */
  CompletableFuture<Void> disable();

  /**
   * Select a device in response to a DeviceAccess.deviceRequestPrompted event.
   */
  CompletableFuture<Void> selectPrompt(SelectPromptRequest request);

  /**
   * Cancel a prompt in response to a DeviceAccess.deviceRequestPrompted event.
   */
  CompletableFuture<Void> cancelPrompt(CancelPromptRequest request);

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
