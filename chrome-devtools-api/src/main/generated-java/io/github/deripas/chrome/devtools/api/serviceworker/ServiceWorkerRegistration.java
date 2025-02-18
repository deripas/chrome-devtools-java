package io.github.deripas.chrome.devtools.api.serviceworker;

import java.lang.Boolean;
import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * ServiceWorker registration.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ServiceWorkerRegistration {
  private final RegistrationID registrationId;

  private final String scopeURL;

  private final Boolean isDeleted;
}
