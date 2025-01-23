package org.deripas.chrome.protocol.api.webauthn;

import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

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
  void enable(EnableRequest request);

  /**
   * Disable the WebAuthn domain.
   */
  void disable();

  /**
   * Creates and adds a virtual authenticator.
   */
  CompletableFuture<AddVirtualAuthenticatorResponse> addVirtualAuthenticator(
      AddVirtualAuthenticatorRequest request);

  /**
   * Resets parameters isBogusSignature, isBadUV, isBadUP to false if they are not present.
   */
  void setResponseOverrideBits(SetResponseOverrideBitsRequest request);

  /**
   * Removes the given authenticator.
   */
  void removeVirtualAuthenticator(RemoveVirtualAuthenticatorRequest request);

  /**
   * Adds the credential to the specified authenticator.
   */
  void addCredential(AddCredentialRequest request);

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
  void removeCredential(RemoveCredentialRequest request);

  /**
   * Clears all the credentials from the specified device.
   */
  void clearCredentials(ClearCredentialsRequest request);

  /**
   * Sets whether User Verification succeeds or fails for an authenticator.
   * The default is true.
   */
  void setUserVerified(SetUserVerifiedRequest request);

  /**
   * Sets whether tests of user presence will succeed immediately (if true) or fail to resolve (if false) for an authenticator.
   * The default is true.
   */
  void setAutomaticPresenceSimulation(SetAutomaticPresenceSimulationRequest request);

  /**
   * Allows setting credential properties.
   * https://w3c.github.io/webauthn/#sctn-automation-set-credential-properties
   */
  void setCredentialProperties(SetCredentialPropertiesRequest request);

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
}
