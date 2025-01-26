package org.deripas.chrome.protocol.api.fetch.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.fetch.AuthChallenge;
import org.deripas.chrome.protocol.api.fetch.RequestId;
import org.deripas.chrome.protocol.api.network.Request;
import org.deripas.chrome.protocol.api.network.ResourceType;
import org.deripas.chrome.protocol.api.page.FrameId;

/**
 * Issued when the domain is enabled with handleAuthRequests set to true.
 * The request is paused until client responds with continueWithAuth.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class AuthRequiredEvent {
  public static final EventId<AuthRequiredEvent> ID = new EventId<>("Fetch.authRequired", AuthRequiredEvent.class);

  /**
   * Each request the page makes will have a unique id.
   */
  private final RequestId requestId;

  /**
   * The details of the request.
   */
  private final Request request;

  /**
   * The id of the frame that initiated the request.
   */
  private final FrameId frameId;

  /**
   * How the requested resource will be used.
   */
  private final ResourceType resourceType;

  /**
   * Details of the Authorization Challenge encountered.
   * If this is set, client should respond with continueRequest that
   * contains AuthChallengeResponse.
   */
  private final AuthChallenge authChallenge;
}
