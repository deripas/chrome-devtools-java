package org.deripas.chrome.protocol.api.security;

import java.lang.Boolean;
import java.lang.Deprecated;
import java.lang.Integer;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Security
 */
@Generated
public interface Security {
  /**
   * Disables tracking security state changes.
   */
  void disable();

  /**
   * Enables tracking security state changes.
   */
  void enable();

  /**
   * Enable/disable whether all certificate errors should be ignored.
   */
  void setIgnoreCertificateErrors(SetIgnoreCertificateErrorsRequest request);

  /**
   * Handles a certificate error that fired a certificateError event.
   */
  @Deprecated
  void handleCertificateError(HandleCertificateErrorRequest request);

  /**
   * Enable/disable overriding certificate errors. If enabled, all certificate error events need to
   * be handled by the DevTools client and should be answered with `handleCertificateError` commands.
   */
  @Deprecated
  void setOverrideCertificateErrors(SetOverrideCertificateErrorsRequest request);

  @Data
  @Builder(
      toBuilder = true
  )
  class SetIgnoreCertificateErrorsRequest {
    /**
     * If true, all certificate errors will be ignored.
     */
    private final Boolean ignore;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class HandleCertificateErrorRequest {
    /**
     * The ID of the event.
     */
    private final Integer eventId;

    /**
     * The action to take on the certificate error.
     */
    private final CertificateErrorAction action;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetOverrideCertificateErrorsRequest {
    /**
     * If true, certificate errors will be overridden.
     */
    private final Boolean override;
  }
}
