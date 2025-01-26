package org.deripas.chrome.protocol.api.network.event;

import java.lang.Boolean;
import java.util.List;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.network.AssociatedCookie;
import org.deripas.chrome.protocol.api.network.ClientSecurityState;
import org.deripas.chrome.protocol.api.network.ConnectTiming;
import org.deripas.chrome.protocol.api.network.Headers;
import org.deripas.chrome.protocol.api.network.RequestId;

/**
 * Fired when additional information about a requestWillBeSent event is available from the
 * network stack. Not every requestWillBeSent event will have an additional
 * requestWillBeSentExtraInfo fired for it, and there is no guarantee whether requestWillBeSent
 * or requestWillBeSentExtraInfo will be fired first for the same request.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class RequestWillBeSentExtraInfoEvent {
  public static final EventId<RequestWillBeSentExtraInfoEvent> ID = new EventId<>("Network.requestWillBeSentExtraInfo", RequestWillBeSentExtraInfoEvent.class);

  /**
   * Request identifier. Used to match this information to an existing requestWillBeSent event.
   */
  private final RequestId requestId;

  /**
   * A list of cookies potentially associated to the requested URL. This includes both cookies sent with
   * the request and the ones not sent; the latter are distinguished by having blockedReasons field set.
   */
  private final List<AssociatedCookie> associatedCookies;

  /**
   * Raw request headers as they will be sent over the wire.
   */
  private final Headers headers;

  /**
   * Connection timing information for the request.
   */
  @Experimental
  private final ConnectTiming connectTiming;

  /**
   * The client security state set for the request.
   */
  @Nullable
  private final ClientSecurityState clientSecurityState;

  /**
   * Whether the site has partitioned cookies stored in a partition different than the current one.
   */
  @Nullable
  private final Boolean siteHasCookieInOtherPartition;
}
