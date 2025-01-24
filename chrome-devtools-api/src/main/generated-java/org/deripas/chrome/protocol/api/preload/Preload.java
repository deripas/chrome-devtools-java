package org.deripas.chrome.protocol.api.preload;

import java.lang.Void;
import java.util.concurrent.CompletableFuture;
import jdk.jfr.Experimental;
import lombok.Generated;

@Experimental
@Generated
public interface Preload {
  CompletableFuture<Void> enable();

  CompletableFuture<Void> disable();
}
