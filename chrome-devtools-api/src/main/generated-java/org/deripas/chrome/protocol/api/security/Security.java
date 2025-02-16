package org.deripas.chrome.protocol.api.security;

import com.fasterxml.jackson.annotation.JsonTypeName;
import java.lang.Boolean;
import java.lang.Deprecated;
import java.lang.Integer;
import java.lang.String;
import java.lang.Void;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.Disposable;

/**
 * Security
 */
@Generated
public interface Security {
  /**
   * Disables tracking security state changes.
   */
  CompletableFuture<Void> disable();

  /**
   * Enables tracking security state changes.
   */
  CompletableFuture<Void> enable();

  /**
   * Enable/disable whether all certificate errors should be ignored.
   */
  CompletableFuture<Void> setIgnoreCertificateErrors(SetIgnoreCertificateErrorsRequest request);

  /**
   * Handles a certificate error that fired a certificateError event.
   */
  @Deprecated
  CompletableFuture<Void> handleCertificateError(HandleCertificateErrorRequest request);

  /**
   * Enable/disable overriding certificate errors. If enabled, all certificate error events need to
   * be handled by the DevTools client and should be answered with `handleCertificateError` commands.
   */
  @Deprecated
  CompletableFuture<Void> setOverrideCertificateErrors(SetOverrideCertificateErrorsRequest request);

  Disposable onCertificateError(Consumer<CertificateErrorEvent> listener);

  Disposable onVisibleSecurityStateChanged(Consumer<VisibleSecurityStateChangedEvent> listener);

  Disposable onSecurityStateChanged(Consumer<SecurityStateChangedEvent> listener);

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

  /**
   * There is a certificate error. If overriding certificate errors is enabled, then it should be
   * handled with the `handleCertificateError` command. Note: this event does not fire if the
   * certificate error has been allowed internally. Only one client per target should override
   * certificate errors at the same time.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("certificateError")
  class CertificateErrorEvent {
    /**
     * The ID of the event.
     */
    private final Integer eventId;

    /**
     * The type of the error.
     */
    private final String errorType;

    /**
     * The url that was requested.
     */
    private final String requestURL;
  }

  /**
   * The security state of the page changed.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("visibleSecurityStateChanged")
  class VisibleSecurityStateChangedEvent {
    /**
     * Security state information about the page.
     */
    private final VisibleSecurityState visibleSecurityState;
  }

  /**
   * The security state of the page changed. No longer being sent.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("securityStateChanged")
  class SecurityStateChangedEvent {
    /**
     * Security state.
     */
    private final SecurityState securityState;

    /**
     * True if the page was loaded over cryptographic transport such as HTTPS.
     */
    @Deprecated
    private final Boolean schemeIsCryptographic;

    /**
     * Previously a list of explanations for the security state. Now always
     * empty.
     */
    @Deprecated
    private final List<SecurityStateExplanation> explanations;

    /**
     * Information about insecure content on the page.
     */
    @Deprecated
    private final InsecureContentStatus insecureContentStatus;

    /**
     * Overrides user-visible description of the state. Always omitted.
     */
    @Nullable
    @Deprecated
    private final String summary;
  }
}
