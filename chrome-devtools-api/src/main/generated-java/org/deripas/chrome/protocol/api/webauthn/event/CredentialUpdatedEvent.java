package org.deripas.chrome.protocol.api.webauthn.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.webauthn.AuthenticatorId;
import org.deripas.chrome.protocol.api.webauthn.Credential;

/**
 * Triggered when a credential is updated, e.g. through
 * PublicKeyCredential.signalCurrentUserDetails().
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class CredentialUpdatedEvent {
  public static final EventId<CredentialUpdatedEvent> ID = new EventId<>("WebAuthn.credentialUpdated", CredentialUpdatedEvent.class);

  private final AuthenticatorId authenticatorId;

  private final Credential credential;
}
