package io.github.deripas.chrome.devtools.api.deviceaccess;

import com.fasterxml.jackson.annotation.JsonTypeName;
import io.github.deripas.chrome.devtools.api.Disposable;
import java.lang.Void;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
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

  Disposable onDeviceRequestPrompted(Consumer<DeviceRequestPromptedEvent> listener);

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

  /**
   * A device request opened a user prompt to select a device. Respond with the
   * selectPrompt or cancelPrompt command.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("deviceRequestPrompted")
  class DeviceRequestPromptedEvent {
    private final RequestId id;

    private final List<PromptDevice> devices;
  }
}
