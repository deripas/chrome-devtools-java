package org.deripas.chrome.protocol.api.console;

import java.lang.Deprecated;
import java.lang.Void;
import java.util.concurrent.CompletableFuture;
import lombok.Generated;

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
}
