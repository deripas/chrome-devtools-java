package org.deripas.chrome.protocol.api.webauthn;

import java.lang.Boolean;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class VirtualAuthenticatorOptions {
  private final AuthenticatorProtocol protocol;

  /**
   * Defaults to ctap2_0. Ignored if |protocol| == u2f.
   */
  @Nullable
  private final Ctap2Version ctap2Version;

  private final AuthenticatorTransport transport;

  /**
   * Defaults to false.
   */
  @Nullable
  private final Boolean hasResidentKey;

  /**
   * Defaults to false.
   */
  @Nullable
  private final Boolean hasUserVerification;

  /**
   * If set to true, the authenticator will support the largeBlob extension.
   * https://w3c.github.io/webauthn#largeBlob
   * Defaults to false.
   */
  @Nullable
  private final Boolean hasLargeBlob;

  /**
   * If set to true, the authenticator will support the credBlob extension.
   * https://fidoalliance.org/specs/fido-v2.1-rd-20201208/fido-client-to-authenticator-protocol-v2.1-rd-20201208.html#sctn-credBlob-extension
   * Defaults to false.
   */
  @Nullable
  private final Boolean hasCredBlob;

  /**
   * If set to true, the authenticator will support the minPinLength extension.
   * https://fidoalliance.org/specs/fido-v2.1-ps-20210615/fido-client-to-authenticator-protocol-v2.1-ps-20210615.html#sctn-minpinlength-extension
   * Defaults to false.
   */
  @Nullable
  private final Boolean hasMinPinLength;

  /**
   * If set to true, the authenticator will support the prf extension.
   * https://w3c.github.io/webauthn/#prf-extension
   * Defaults to false.
   */
  @Nullable
  private final Boolean hasPrf;

  /**
   * If set to true, tests of user presence will succeed immediately.
   * Otherwise, they will not be resolved. Defaults to true.
   */
  @Nullable
  private final Boolean automaticPresenceSimulation;

  /**
   * Sets whether User Verification succeeds or fails for an authenticator.
   * Defaults to false.
   */
  @Nullable
  private final Boolean isUserVerified;

  /**
   * Credentials created by this authenticator will have the backup
   * eligibility (BE) flag set to this value. Defaults to false.
   * https://w3c.github.io/webauthn/#sctn-credential-backup
   */
  @Nullable
  private final Boolean defaultBackupEligibility;

  /**
   * Credentials created by this authenticator will have the backup state
   * (BS) flag set to this value. Defaults to false.
   * https://w3c.github.io/webauthn/#sctn-credential-backup
   */
  @Nullable
  private final Boolean defaultBackupState;
}
