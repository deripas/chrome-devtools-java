package org.deripas.chrome.protocol.api.network.event;

import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.network.RequestId;

/**
 * Fired when request for resources within a .wbn file failed.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class SubresourceWebBundleInnerResponseErrorEvent {
  public static final EventId<SubresourceWebBundleInnerResponseErrorEvent> ID = new EventId<>("Network.subresourceWebBundleInnerResponseError", SubresourceWebBundleInnerResponseErrorEvent.class);

  /**
   * Request identifier of the subresource request
   */
  private final RequestId innerRequestId;

  /**
   * URL of the subresource resource.
   */
  private final String innerRequestURL;

  /**
   * Error message
   */
  private final String errorMessage;

  /**
   * Bundle request identifier. Used to match this information to another event.
   * This made be absent in case when the instrumentation was enabled only
   * after webbundle was parsed.
   */
  @Nullable
  private final RequestId bundleRequestId;
}
