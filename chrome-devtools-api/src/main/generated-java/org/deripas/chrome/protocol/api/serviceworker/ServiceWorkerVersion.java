package org.deripas.chrome.protocol.api.serviceworker;

import java.lang.Long;
import java.lang.String;
import java.util.List;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.target.TargetID;

/**
 * ServiceWorker version.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ServiceWorkerVersion {
  private final String versionId;

  private final RegistrationID registrationId;

  private final String scriptURL;

  private final ServiceWorkerVersionRunningStatus runningStatus;

  private final ServiceWorkerVersionStatus status;

  /**
   * The Last-Modified header value of the main script.
   */
  @Nullable
  private final Long scriptLastModified;

  /**
   * The time at which the response headers of the main script were received from the server.
   * For cached script it is the last time the cache entry was validated.
   */
  @Nullable
  private final Long scriptResponseTime;

  @Nullable
  private final List<TargetID> controlledClients;

  @Nullable
  private final TargetID targetId;

  @Nullable
  private final String routerRules;
}
