package org.deripas.chrome.protocol.api.media;

import java.lang.Void;
import java.util.concurrent.CompletableFuture;
import jdk.jfr.Experimental;
import lombok.Generated;

/**
 * This domain allows detailed inspection of media elements
 */
@Experimental
@Generated
public interface Media {
  /**
   * Enables the Media domain
   */
  CompletableFuture<Void> enable();

  /**
   * Disables the Media domain.
   */
  CompletableFuture<Void> disable();
}
