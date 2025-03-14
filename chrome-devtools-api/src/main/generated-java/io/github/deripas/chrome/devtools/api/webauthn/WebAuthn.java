package io.github.deripas.chrome.devtools.api.webauthn;

import io.github.deripas.chrome.devtools.api.Disposable;
import io.github.deripas.chrome.devtools.api.Session;
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
import lombok.RequiredArgsConstructor;

/**
 * This domain allows configuring virtual authenticators to test the WebAuthn
 * API.
 */
@RequiredArgsConstructor
@Experimental
@Generated
public class WebAuthn {
  private final Session session;

  /**
   * Enable the WebAuthn domain and start intercepting credential storage and
   * retrieval with a virtual authenticator.
   */
  public CompletableFuture<Void> enable(EnableRequest request) {
    return session.send("WebAuthn.enable", request, Void.class);
  }

  /**
   * Disable the WebAuthn domain.
   */
  public CompletableFuture<Void> disable() {
    return session.send("WebAuthn.disable", null, Void.class);
  }

  /**
   * Creates and adds a virtual authenticator.
   */
  public CompletableFuture<AddVirtualAuthenticatorResponse> addVirtualAuthenticator(
      AddVirtualAuthenticatorRequest request) {
    return session.send("WebAuthn.addVirtualAuthenticator", request, AddVirtualAuthenticatorResponse.class);
  }

  /**
   * Resets parameters isBogusSignature, isBadUV, isBadUP to false if they are not present.
   */
  public CompletableFuture<Void> setResponseOverrideBits(SetResponseOverrideBitsRequest request) {
    return session.send("WebAuthn.setResponseOverrideBits", request, Void.class);
  }

  /**
   * Removes the given authenticator.
   */
  public CompletableFuture<Void> removeVirtualAuthenticator(
      RemoveVirtualAuthenticatorRequest request) {
    return session.send("WebAuthn.removeVirtualAuthenticator", request, Void.class);
  }

  /**
   * Adds the credential to the specified authenticator.
   */
  public CompletableFuture<Void> addCredential(AddCredentialRequest request) {
    return session.send("WebAuthn.addCredential", request, Void.class);
  }

  /**
   * Returns a single credential stored in the given virtual authenticator that
   * matches the credential ID.
   */
  public CompletableFuture<GetCredentialResponse> getCredential(GetCredentialRequest request) {
    return session.send("WebAuthn.getCredential", request, GetCredentialResponse.class);
  }

  /**
   * Returns all the credentials stored in the given virtual authenticator.
   */
  public CompletableFuture<GetCredentialsResponse> getCredentials(GetCredentialsRequest request) {
    return session.send("WebAuthn.getCredentials", request, GetCredentialsResponse.class);
  }

  /**
   * Removes a credential from the authenticator.
   */
  public CompletableFuture<Void> removeCredential(RemoveCredentialRequest request) {
    return session.send("WebAuthn.removeCredential", request, Void.class);
  }

  /**
   * Clears all the credentials from the specified device.
   */
  public CompletableFuture<Void> clearCredentials(ClearCredentialsRequest request) {
    return session.send("WebAuthn.clearCredentials", request, Void.class);
  }

  /**
   * Sets whether User Verification succeeds or fails for an authenticator.
   * The default is true.
   */
  public CompletableFuture<Void> setUserVerified(SetUserVerifiedRequest request) {
    return session.send("WebAuthn.setUserVerified", request, Void.class);
  }

  /**
   * Sets whether tests of user presence will succeed immediately (if true) or fail to resolve (if false) for an authenticator.
   * The default is true.
   */
  public CompletableFuture<Void> setAutomaticPresenceSimulation(
      SetAutomaticPresenceSimulationRequest request) {
    return session.send("WebAuthn.setAutomaticPresenceSimulation", request, Void.class);
  }

  /**
   * Allows setting credential properties.
   * https://w3c.github.io/webauthn/#sctn-automation-set-credential-properties
   */
  public CompletableFuture<Void> setCredentialProperties(SetCredentialPropertiesRequest request) {
    return session.send("WebAuthn.setCredentialProperties", request, Void.class);
  }

  public Disposable onCredentialAdded(Consumer<CredentialAddedEvent> listener) {
    return session.subscribe("WebAuthn.credentialAdded", listener, CredentialAddedEvent.class);
  }

  public Disposable onCredentialDeleted(Consumer<CredentialDeletedEvent> listener) {
    return session.subscribe("WebAuthn.credentialDeleted", listener, CredentialDeletedEvent.class);
  }

  public Disposable onCredentialUpdated(Consumer<CredentialUpdatedEvent> listener) {
    return session.subscribe("WebAuthn.credentialUpdated", listener, CredentialUpdatedEvent.class);
  }

  public Disposable onCredentialAsserted(Consumer<CredentialAssertedEvent> listener) {
    return session.subscribe("WebAuthn.credentialAsserted", listener, CredentialAssertedEvent.class);
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class EnableRequest {
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
  public static class AddVirtualAuthenticatorRequest {
    private final VirtualAuthenticatorOptions options;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class AddVirtualAuthenticatorResponse {
    private final AuthenticatorId authenticatorId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetResponseOverrideBitsRequest {
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
  public static class RemoveVirtualAuthenticatorRequest {
    private final AuthenticatorId authenticatorId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class AddCredentialRequest {
    private final AuthenticatorId authenticatorId;

    private final Credential credential;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetCredentialRequest {
    private final AuthenticatorId authenticatorId;

    private final String credentialId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetCredentialResponse {
    private final Credential credential;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetCredentialsRequest {
    private final AuthenticatorId authenticatorId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetCredentialsResponse {
    private final List<Credential> credentials;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class RemoveCredentialRequest {
    private final AuthenticatorId authenticatorId;

    private final String credentialId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class ClearCredentialsRequest {
    private final AuthenticatorId authenticatorId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetUserVerifiedRequest {
    private final AuthenticatorId authenticatorId;

    private final Boolean isUserVerified;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetAutomaticPresenceSimulationRequest {
    private final AuthenticatorId authenticatorId;

    private final Boolean enabled;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetCredentialPropertiesRequest {
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
  public static class CredentialAddedEvent {
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
  public static class CredentialDeletedEvent {
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
  public static class CredentialUpdatedEvent {
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
  public static class CredentialAssertedEvent {
    private final AuthenticatorId authenticatorId;

    private final Credential credential;
  }
}
