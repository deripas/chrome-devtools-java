package io.github.deripas.chrome.devtools.api.console;

import com.fasterxml.jackson.annotation.JsonTypeName;
import java.lang.Deprecated;
import java.lang.Void;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import io.github.deripas.chrome.devtools.api.Disposable;

/**
 * This domain is deprecated - use Runtime or Log instead.
 */
@Deprecated
@Generated
public interface Console {
  /**
   * Does nothing.
   */
  CompletableFuture<Void> clearMessages();

  /**
   * Disables console domain, prevents further console messages from being reported to the client.
   */
  CompletableFuture<Void> disable();

  /**
   * Enables console domain, sends the messages collected so far to the client by means of the
   * `messageAdded` notification.
   */
  CompletableFuture<Void> enable();

  Disposable onMessageAdded(Consumer<MessageAddedEvent> listener);

  /**
   * Issued when new console message is added.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("messageAdded")
  class MessageAddedEvent {
    /**
     * Console message that has been added.
     */
    private final ConsoleMessage message;
  }
}
