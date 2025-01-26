package org.deripas.chrome.protocol.api.storage.event;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.network.RequestId;
import org.deripas.chrome.protocol.api.storage.InterestGroupAuctionFetchType;
import org.deripas.chrome.protocol.api.storage.InterestGroupAuctionId;

/**
 * Specifies which auctions a particular network fetch may be related to, and
 * in what role. Note that it is not ordered with respect to
 * Network.requestWillBeSent (but will happen before loadingFinished
 * loadingFailed).
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class InterestGroupAuctionNetworkRequestCreatedEvent {
  public static final EventId<InterestGroupAuctionNetworkRequestCreatedEvent> ID = new EventId<>("Storage.interestGroupAuctionNetworkRequestCreated", InterestGroupAuctionNetworkRequestCreatedEvent.class);

  private final InterestGroupAuctionFetchType type;

  private final RequestId requestId;

  /**
   * This is the set of the auctions using the worklet that issued this
   * request.  In the case of trusted signals, it's possible that only some of
   * them actually care about the keys being queried.
   */
  private final List<InterestGroupAuctionId> auctions;
}
