package org.deripas.chrome.protocol.api.network.event;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.network.BlockedSetCookieWithReason;
import org.deripas.chrome.protocol.api.network.CookiePartitionKey;
import org.deripas.chrome.protocol.api.network.ExemptedSetCookieWithReason;
import org.deripas.chrome.protocol.api.network.Headers;
import org.deripas.chrome.protocol.api.network.IPAddressSpace;
import org.deripas.chrome.protocol.api.network.RequestId;

/**
 * Fired when additional information about a responseReceived event is available from the network
 * stack. Not every responseReceived event will have an additional responseReceivedExtraInfo for
 * it, and responseReceivedExtraInfo may be fired before or after responseReceived.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ResponseReceivedExtraInfoEvent {
  public static final EventId<ResponseReceivedExtraInfoEvent> ID = new EventId<>("Network.responseReceivedExtraInfo", ResponseReceivedExtraInfoEvent.class);

  /**
   * Request identifier. Used to match this information to another responseReceived event.
   */
  private final RequestId requestId;

  /**
   * A list of cookies which were not stored from the response along with the corresponding
   * reasons for blocking. The cookies here may not be valid due to syntax errors, which
   * are represented by the invalid cookie line string instead of a proper cookie.
   */
  private final List<BlockedSetCookieWithReason> blockedCookies;

  /**
   * Raw response headers as they were received over the wire.
   * Duplicate headers in the response are represented as a single key with their values
   * concatentated using `\n` as the separator.
   * See also `headersText` that contains verbatim text for HTTP/1.*.
   */
  private final Headers headers;

  /**
   * The IP address space of the resource. The address space can only be determined once the transport
   * established the connection, so we can't send it in `requestWillBeSentExtraInfo`.
   */
  private final IPAddressSpace resourceIPAddressSpace;

  /**
   * The status code of the response. This is useful in cases the request failed and no responseReceived
   * event is triggered, which is the case for, e.g., CORS errors. This is also the correct status code
   * for cached requests, where the status in responseReceived is a 200 and this will be 304.
   */
  private final Integer statusCode;

  /**
   * Raw response header text as it was received over the wire. The raw text may not always be
   * available, such as in the case of HTTP/2 or QUIC.
   */
  @Nullable
  private final String headersText;

  /**
   * The cookie partition key that will be used to store partitioned cookies set in this response.
   * Only sent when partitioned cookies are enabled.
   */
  @Nullable
  @Experimental
  private final CookiePartitionKey cookiePartitionKey;

  /**
   * True if partitioned cookies are enabled, but the partition key is not serializable to string.
   */
  @Nullable
  private final Boolean cookiePartitionKeyOpaque;

  /**
   * A list of cookies which should have been blocked by 3PCD but are exempted and stored from
   * the response with the corresponding reason.
   */
  @Nullable
  private final List<ExemptedSetCookieWithReason> exemptedCookies;
}
