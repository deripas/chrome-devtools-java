package org.deripas.chrome.protocol.api.network.event;

import java.lang.String;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.network.RequestId;

/**
 * Fired once when parsing the .wbn file has succeeded.
 * The event contains the information about the web bundle contents.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class SubresourceWebBundleMetadataReceivedEvent {
  public static final EventId<SubresourceWebBundleMetadataReceivedEvent> ID = new EventId<>("Network.subresourceWebBundleMetadataReceived", SubresourceWebBundleMetadataReceivedEvent.class);

  /**
   * Request identifier. Used to match this information to another event.
   */
  private final RequestId requestId;

  /**
   * A list of URLs of resources in the subresource Web Bundle.
   */
  private final List<String> urls;
}
