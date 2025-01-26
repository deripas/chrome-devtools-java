package org.deripas.chrome.protocol.api.network.event;

import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.network.RequestId;

/**
 * Fired once when parsing the .wbn file has failed.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class SubresourceWebBundleMetadataErrorEvent {
  public static final EventId<SubresourceWebBundleMetadataErrorEvent> ID = new EventId<>("Network.subresourceWebBundleMetadataError", SubresourceWebBundleMetadataErrorEvent.class);

  /**
   * Request identifier. Used to match this information to another event.
   */
  private final RequestId requestId;

  /**
   * Error message
   */
  private final String errorMessage;
}
