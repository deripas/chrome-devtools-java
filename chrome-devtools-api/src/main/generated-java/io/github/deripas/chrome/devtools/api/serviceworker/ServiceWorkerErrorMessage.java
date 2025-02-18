package io.github.deripas.chrome.devtools.api.serviceworker;

import java.lang.Integer;
import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * ServiceWorker error message.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ServiceWorkerErrorMessage {
  private final String errorMessage;

  private final RegistrationID registrationId;

  private final String versionId;

  private final String sourceURL;

  private final Integer lineNumber;

  private final Integer columnNumber;
}
