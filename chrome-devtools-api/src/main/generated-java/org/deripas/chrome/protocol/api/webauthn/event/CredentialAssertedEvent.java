package org.deripas.chrome.protocol.api.webauthn.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.webauthn.AuthenticatorId;
import org.deripas.chrome.protocol.api.webauthn.Credential;

/**
 * Triggered when a credential is used in a webauthn assertion.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class CredentialAssertedEvent {
  public static final EventId<CredentialAssertedEvent> ID = new EventId<>("WebAuthn.credentialAsserted", CredentialAssertedEvent.class);

  private final AuthenticatorId authenticatorId;

  private final Credential credential;
}
