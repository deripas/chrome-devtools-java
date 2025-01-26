package org.deripas.chrome.protocol.api.security.event;

import java.lang.Integer;
import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;

/**
 * There is a certificate error. If overriding certificate errors is enabled, then it should be
 * handled with the `handleCertificateError` command. Note: this event does not fire if the
 * certificate error has been allowed internally. Only one client per target should override
 * certificate errors at the same time.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class CertificateErrorEvent {
  public static final EventId<CertificateErrorEvent> ID = new EventId<>("Security.certificateError", CertificateErrorEvent.class);

  /**
   * The ID of the event.
   */
  private final Integer eventId;

  /**
   * The type of the error.
   */
  private final String errorType;

  /**
   * The url that was requested.
   */
  private final String requestURL;
}
