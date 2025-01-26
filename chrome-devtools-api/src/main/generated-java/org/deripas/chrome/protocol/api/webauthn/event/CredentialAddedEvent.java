package org.deripas.chrome.protocol.api.webauthn.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.webauthn.AuthenticatorId;
import org.deripas.chrome.protocol.api.webauthn.Credential;

/**
 * Triggered when a credential is added to an authenticator.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class CredentialAddedEvent {
  public static final EventId<CredentialAddedEvent> ID = new EventId<>("WebAuthn.credentialAdded", CredentialAddedEvent.class);

  private final AuthenticatorId authenticatorId;

  private final Credential credential;
}
