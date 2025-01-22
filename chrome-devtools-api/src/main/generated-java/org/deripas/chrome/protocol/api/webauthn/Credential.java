package org.deripas.chrome.protocol.api.webauthn;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class Credential {
  private final String credentialId;

  private final Boolean isResidentCredential;

  /**
   * Relying Party ID the credential is scoped to. Must be set when adding a
   * credential.
   */
  @Nullable
  private final String rpId;

  /**
   * The ECDSA P-256 private key in PKCS#8 format. (Encoded as a base64 string when passed over JSON)
   */
  private final String privateKey;

  /**
   * An opaque byte sequence with a maximum size of 64 bytes mapping the
   * credential to a specific user. (Encoded as a base64 string when passed over JSON)
   */
  @Nullable
  private final String userHandle;

  /**
   * Signature counter. This is incremented by one for each successful
   * assertion.
   * See https://w3c.github.io/webauthn/#signature-counter
   */
  private final Integer signCount;

  /**
   * The large blob associated with the credential.
   * See https://w3c.github.io/webauthn/#sctn-large-blob-extension (Encoded as a base64 string when passed over JSON)
   */
  @Nullable
  private final String largeBlob;

  /**
   * Assertions returned by this credential will have the backup eligibility
   * (BE) flag set to this value. Defaults to the authenticator's
   * defaultBackupEligibility value.
   */
  @Nullable
  private final Boolean backupEligibility;

  /**
   * Assertions returned by this credential will have the backup state (BS)
   * flag set to this value. Defaults to the authenticator's
   * defaultBackupState value.
   */
  @Nullable
  private final Boolean backupState;

  /**
   * The credential's user.name property. Equivalent to empty if not set.
   * https://w3c.github.io/webauthn/#dom-publickeycredentialentity-name
   */
  @Nullable
  private final String userName;

  /**
   * The credential's user.displayName property. Equivalent to empty if
   * not set.
   * https://w3c.github.io/webauthn/#dom-publickeycredentialuserentity-displayname
   */
  @Nullable
  private final String userDisplayName;
}
