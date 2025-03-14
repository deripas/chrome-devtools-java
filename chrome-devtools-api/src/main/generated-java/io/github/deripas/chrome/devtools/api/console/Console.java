package io.github.deripas.chrome.devtools.api.console;

import io.github.deripas.chrome.devtools.api.Disposable;
import io.github.deripas.chrome.devtools.api.Session;
import java.lang.Deprecated;
import java.lang.Void;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.RequiredArgsConstructor;

/**
 * This domain is deprecated - use Runtime or Log instead.
 */
@RequiredArgsConstructor
@Deprecated
@Generated
public class Console {
  private final Session session;

  /**
   * Does nothing.
   */
  public CompletableFuture<Void> clearMessages() {
    return session.send("Console.clearMessages", null, Void.class);
  }

  /**
   * Disables console domain, prevents further console messages from being reported to the client.
   */
  public CompletableFuture<Void> disable() {
    return session.send("Console.disable", null, Void.class);
  }

  /**
   * Enables console domain, sends the messages collected so far to the client by means of the
   * `messageAdded` notification.
   */
  public CompletableFuture<Void> enable() {
    return session.send("Console.enable", null, Void.class);
  }

  public Disposable onMessageAdded(Consumer<MessageAddedEvent> listener) {
    return session.subscribe("Console.messageAdded", listener, MessageAddedEvent.class);
  }

  /**
   * Issued when new console message is added.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class MessageAddedEvent {
    /**
     * Console message that has been added.
     */
    private final ConsoleMessage message;
  }
}
