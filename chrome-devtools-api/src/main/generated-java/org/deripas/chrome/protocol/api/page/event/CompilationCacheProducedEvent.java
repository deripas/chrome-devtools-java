package org.deripas.chrome.protocol.api.page.event;

import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;

/**
 * Issued for every compilation cache generated. Is only available
 * if Page.setGenerateCompilationCache is enabled.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class CompilationCacheProducedEvent {
  public static final EventId<CompilationCacheProducedEvent> ID = new EventId<>("Page.compilationCacheProduced", CompilationCacheProducedEvent.class);

  private final String url;

  /**
   * Base64-encoded data (Encoded as a base64 string when passed over JSON)
   */
  private final String data;
}
