package io.github.deripas.chrome.devtools.api.deviceaccess;

import io.github.deripas.chrome.devtools.api.Disposable;
import io.github.deripas.chrome.devtools.api.Session;
import java.lang.Void;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Experimental
@Generated
public class DeviceAccess {
  private final Session session;

  /**
   * Enable events in this domain.
   */
  public CompletableFuture<Void> enable() {
    return session.send("DeviceAccess.enable", null, Void.class);
  }

  /**
   * Disable events in this domain.
   */
  public CompletableFuture<Void> disable() {
    return session.send("DeviceAccess.disable", null, Void.class);
  }

  /**
   * Select a device in response to a DeviceAccess.deviceRequestPrompted event.
   */
  public CompletableFuture<Void> selectPrompt(SelectPromptRequest request) {
    return session.send("DeviceAccess.selectPrompt", request, Void.class);
  }

  /**
   * Cancel a prompt in response to a DeviceAccess.deviceRequestPrompted event.
   */
  public CompletableFuture<Void> cancelPrompt(CancelPromptRequest request) {
    return session.send("DeviceAccess.cancelPrompt", request, Void.class);
  }

  public Disposable onDeviceRequestPrompted(Consumer<DeviceRequestPromptedEvent> listener) {
    return session.subscribe("DeviceAccess.deviceRequestPrompted", listener, DeviceRequestPromptedEvent.class);
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SelectPromptRequest {
    private final RequestId id;

    private final DeviceId deviceId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class CancelPromptRequest {
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
  public static class DeviceRequestPromptedEvent {
    private final RequestId id;

    private final List<PromptDevice> devices;
  }
}
