package org.deripas.chrome.protocol.api.storage.event;

import java.util.Map;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.network.TimeSinceEpoch;
import org.deripas.chrome.protocol.api.storage.InterestGroupAuctionEventType;
import org.deripas.chrome.protocol.api.storage.InterestGroupAuctionId;

/**
 * An auction involving interest groups is taking place. These events are
 * target-specific.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class InterestGroupAuctionEventOccurredEvent {
  public static final EventId<InterestGroupAuctionEventOccurredEvent> ID = new EventId<>("Storage.interestGroupAuctionEventOccurred", InterestGroupAuctionEventOccurredEvent.class);

  private final TimeSinceEpoch eventTime;

  private final InterestGroupAuctionEventType type;

  private final InterestGroupAuctionId uniqueAuctionId;

  /**
   * Set for child auctions.
   */
  @Nullable
  private final InterestGroupAuctionId parentAuctionId;

  /**
   * Set for started and configResolved
   */
  @Nullable
  private final Map auctionConfig;
}
