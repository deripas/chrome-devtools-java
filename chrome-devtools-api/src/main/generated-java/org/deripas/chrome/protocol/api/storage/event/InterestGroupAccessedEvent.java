package org.deripas.chrome.protocol.api.storage.event;

import java.lang.Long;
import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.network.TimeSinceEpoch;
import org.deripas.chrome.protocol.api.storage.InterestGroupAccessType;
import org.deripas.chrome.protocol.api.storage.InterestGroupAuctionId;

/**
 * One of the interest groups was accessed. Note that these events are global
 * to all targets sharing an interest group store.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class InterestGroupAccessedEvent {
  public static final EventId<InterestGroupAccessedEvent> ID = new EventId<>("Storage.interestGroupAccessed", InterestGroupAccessedEvent.class);

  private final TimeSinceEpoch accessTime;

  private final InterestGroupAccessType type;

  private final String ownerOrigin;

  private final String name;

  /**
   * For topLevelBid/topLevelAdditionalBid, and when appropriate,
   * win and additionalBidWin
   */
  @Nullable
  private final String componentSellerOrigin;

  /**
   * For bid or somethingBid event, if done locally and not on a server.
   */
  @Nullable
  private final Long bid;

  @Nullable
  private final String bidCurrency;

  /**
   * For non-global events --- links to interestGroupAuctionEvent
   */
  @Nullable
  private final InterestGroupAuctionId uniqueAuctionId;
}
