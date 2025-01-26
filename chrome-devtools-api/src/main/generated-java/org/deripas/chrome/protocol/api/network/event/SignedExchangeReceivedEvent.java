package org.deripas.chrome.protocol.api.network.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.network.RequestId;
import org.deripas.chrome.protocol.api.network.SignedExchangeInfo;

/**
 * Fired when a signed exchange was received over the network
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class SignedExchangeReceivedEvent {
  public static final EventId<SignedExchangeReceivedEvent> ID = new EventId<>("Network.signedExchangeReceived", SignedExchangeReceivedEvent.class);

  /**
   * Request identifier.
   */
  private final RequestId requestId;

  /**
   * Information about the signed exchange response.
   */
  private final SignedExchangeInfo info;
}
