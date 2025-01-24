package org.deripas.chrome.protocol.api.inspector;

import java.lang.Void;
import java.util.concurrent.CompletableFuture;
import jdk.jfr.Experimental;
import lombok.Generated;

@Experimental
@Generated
public interface Inspector {
  /**
   * Disables inspector domain notifications.
   */
  CompletableFuture<Void> disable();

  /**
   * Enables inspector domain notifications.
   */
  CompletableFuture<Void> enable();
}
