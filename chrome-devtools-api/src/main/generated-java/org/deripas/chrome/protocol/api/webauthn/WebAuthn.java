package org.deripas.chrome.protocol.api.webauthn;

import com.fasterxml.jackson.annotation.JsonTypeName;
import java.lang.Boolean;
import java.lang.String;
import java.lang.Void;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.Disposable;

/**
 * This domain allows configuring virtual authenticators to test the WebAuthn
 * API.
 */
@Experimental
@Generated
public interface WebAuthn {
  /**
   * Enable the WebAuthn domain and start intercepting credential storage and
   * retrieval with a virtual authenticator.
   */
  CompletableFuture<Void> enable(EnableRequest request);

  /**
   * Disable the WebAuthn domain.
   */
  CompletableFuture<Void> disable();

  /**
   * Creates and adds a virtual authenticator.
   */
  CompletableFuture<AddVirtualAuthenticatorResponse> addVirtualAuthenticator(
      AddVirtualAuthenticatorRequest request);

  /**
   * Resets parameters isBogusSignature, isBadUV, isBadUP to false if they are not present.
   */
  CompletableFuture<Void> setResponseOverrideBits(SetResponseOverrideBitsRequest request);

  /**
   * Removes the given authenticator.
   */
  CompletableFuture<Void> removeVirtualAuthenticator(RemoveVirtualAuthenticatorRequest request);

  /**
   * Adds the credential to the specified authenticator.
   */
  CompletableFuture<Void> addCredential(AddCredentialRequest request);

  /**
   * Returns a single credential stored in the given virtual authenticator that
   * matches the credential ID.
   */
  CompletableFuture<GetCredentialResponse> getCredential(GetCredentialRequest request);

  /**
   * Returns all the credentials stored in the given virtual authenticator.
   */
  CompletableFuture<GetCredentialsResponse> getCredentials(GetCredentialsRequest request);

  /**
   * Removes a credential from the authenticator.
   */
  CompletableFuture<Void> removeCredential(RemoveCredentialRequest request);

  /**
   * Clears all the credentials from the specified device.
   */
  CompletableFuture<Void> clearCredentials(ClearCredentialsRequest request);

  /**
   * Sets whether User Verification succeeds or fails for an authenticator.
   * The default is true.
   */
  CompletableFuture<Void> setUserVerified(SetUserVerifiedRequest request);

  /**
   * Sets whether tests of user presence will succeed immediately (if true) or fail to resolve (if false) for an authenticator.
   * The default is true.
   */
  CompletableFuture<Void> setAutomaticPresenceSimulation(
      SetAutomaticPresenceSimulationRequest request);

  /**
   * Allows setting credential properties.
   * https://w3c.github.io/webauthn/#sctn-automation-set-credential-properties
   */
  CompletableFuture<Void> setCredentialProperties(SetCredentialPropertiesRequest request);

  Disposable onCredentialAdded(Consumer<CredentialAddedEvent> listener);

  Disposable onCredentialDeleted(Consumer<CredentialDeletedEvent> listener);

  Disposable onCredentialUpdated(Consumer<CredentialUpdatedEvent> listener);

  Disposable onCredentialAsserted(Consumer<CredentialAssertedEvent> listener);

  @Data
  @Builder(
      toBuilder = true
  )
  class EnableRequest {
    /**
     * Whether to enable the WebAuthn user interface. Enabling the UI is
     * recommended for debugging and demo purposes, as it is closer to the real
     * experience. Disabling the UI is recommended for automated testing.
     * Supported at the embedder's discretion if UI is available.
     * Defaults to false.
     */
    @Nullable
    private final Boolean enableUI;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class AddVirtualAuthenticatorRequest {
    private final VirtualAuthenticatorOptions options;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class AddVirtualAuthenticatorResponse {
    private final AuthenticatorId authenticatorId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetResponseOverrideBitsRequest {
    private final AuthenticatorId authenticatorId;

    /**
     * If isBogusSignature is set, overrides the signature in the authenticator response to be zero.
     * Defaults to false.
     */
    @Nullable
    private final Boolean isBogusSignature;

    /**
     * If isBadUV is set, overrides the UV bit in the flags in the authenticator response to
     * be zero. Defaults to false.
     */
    @Nullable
    private final Boolean isBadUV;

    /**
     * If isBadUP is set, overrides the UP bit in the flags in the authenticator response to
     * be zero. Defaults to false.
     */
    @Nullable
    private final Boolean isBadUP;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class RemoveVirtualAuthenticatorRequest {
    private final AuthenticatorId authenticatorId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class AddCredentialRequest {
    private final AuthenticatorId authenticatorId;

    private final Credential credential;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetCredentialRequest {
    private final AuthenticatorId authenticatorId;

    private final String credentialId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetCredentialResponse {
    private final Credential credential;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetCredentialsRequest {
    private final AuthenticatorId authenticatorId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetCredentialsResponse {
    private final List<Credential> credentials;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class RemoveCredentialRequest {
    private final AuthenticatorId authenticatorId;

    private final String credentialId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class ClearCredentialsRequest {
    private final AuthenticatorId authenticatorId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetUserVerifiedRequest {
    private final AuthenticatorId authenticatorId;

    private final Boolean isUserVerified;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetAutomaticPresenceSimulationRequest {
    private final AuthenticatorId authenticatorId;

    private final Boolean enabled;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetCredentialPropertiesRequest {
    private final AuthenticatorId authenticatorId;

    private final String credentialId;

    @Nullable
    private final Boolean backupEligibility;

    @Nullable
    private final Boolean backupState;
  }

  /**
   * Triggered when a credential is added to an authenticator.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("credentialAdded")
  class CredentialAddedEvent {
    private final AuthenticatorId authenticatorId;

    private final Credential credential;
  }

  /**
   * Triggered when a credential is deleted, e.g. through
   * PublicKeyCredential.signalUnknownCredential().
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("credentialDeleted")
  class CredentialDeletedEvent {
    private final AuthenticatorId authenticatorId;

    private final String credentialId;
  }

  /**
   * Triggered when a credential is updated, e.g. through
   * PublicKeyCredential.signalCurrentUserDetails().
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("credentialUpdated")
  class CredentialUpdatedEvent {
    private final AuthenticatorId authenticatorId;

    private final Credential credential;
  }

  /**
   * Triggered when a credential is used in a webauthn assertion.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("credentialAsserted")
  class CredentialAssertedEvent {
    private final AuthenticatorId authenticatorId;

    private final Credential credential;
  }
}
