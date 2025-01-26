package org.deripas.chrome.protocol.api.network.event;

import java.lang.Boolean;
import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.network.BlockedReason;
import org.deripas.chrome.protocol.api.network.CorsErrorStatus;
import org.deripas.chrome.protocol.api.network.MonotonicTime;
import org.deripas.chrome.protocol.api.network.RequestId;
import org.deripas.chrome.protocol.api.network.ResourceType;

/**
 * Fired when HTTP request has failed to load.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class LoadingFailedEvent {
  public static final EventId<LoadingFailedEvent> ID = new EventId<>("Network.loadingFailed", LoadingFailedEvent.class);

  /**
   * Request identifier.
   */
  private final RequestId requestId;

  /**
   * Timestamp.
   */
  private final MonotonicTime timestamp;

  /**
   * Resource type.
   */
  private final ResourceType type;

  /**
   * Error message. List of network errors: https://cs.chromium.org/chromium/src/net/base/net_error_list.h
   */
  private final String errorText;

  /**
   * True if loading was canceled.
   */
  @Nullable
  private final Boolean canceled;

  /**
   * The reason why loading was blocked, if any.
   */
  @Nullable
  private final BlockedReason blockedReason;

  /**
   * The reason why loading was blocked by CORS, if any.
   */
  @Nullable
  private final CorsErrorStatus corsErrorStatus;
}
