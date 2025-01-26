package org.deripas.chrome.protocol.api.webauthn.event;

import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.webauthn.AuthenticatorId;

/**
 * Triggered when a credential is deleted, e.g. through
 * PublicKeyCredential.signalUnknownCredential().
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class CredentialDeletedEvent {
  public static final EventId<CredentialDeletedEvent> ID = new EventId<>("WebAuthn.credentialDeleted", CredentialDeletedEvent.class);

  private final AuthenticatorId authenticatorId;

  private final String credentialId;
}
