package io.github.deripas.chrome.devtools.api.security;

import io.github.deripas.chrome.devtools.api.Disposable;
import io.github.deripas.chrome.devtools.api.Session;
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
import lombok.RequiredArgsConstructor;

/**
 * Security
 */
@RequiredArgsConstructor
@Generated
public class Security {
  private final Session session;

  /**
   * Disables tracking security state changes.
   */
  public CompletableFuture<Void> disable() {
    return session.send("Security.disable", null, Void.class);
  }

  /**
   * Enables tracking security state changes.
   */
  public CompletableFuture<Void> enable() {
    return session.send("Security.enable", null, Void.class);
  }

  /**
   * Enable/disable whether all certificate errors should be ignored.
   */
  public CompletableFuture<Void> setIgnoreCertificateErrors(
      SetIgnoreCertificateErrorsRequest request) {
    return session.send("Security.setIgnoreCertificateErrors", request, Void.class);
  }

  /**
   * Handles a certificate error that fired a certificateError event.
   */
  @Deprecated
  public CompletableFuture<Void> handleCertificateError(HandleCertificateErrorRequest request) {
    return session.send("Security.handleCertificateError", request, Void.class);
  }

  /**
   * Enable/disable overriding certificate errors. If enabled, all certificate error events need to
   * be handled by the DevTools client and should be answered with `handleCertificateError` commands.
   */
  @Deprecated
  public CompletableFuture<Void> setOverrideCertificateErrors(
      SetOverrideCertificateErrorsRequest request) {
    return session.send("Security.setOverrideCertificateErrors", request, Void.class);
  }

  public Disposable onCertificateError(Consumer<CertificateErrorEvent> listener) {
    return session.subscribe("Security.certificateError", listener, CertificateErrorEvent.class);
  }

  public Disposable onVisibleSecurityStateChanged(
      Consumer<VisibleSecurityStateChangedEvent> listener) {
    return session.subscribe("Security.visibleSecurityStateChanged", listener, VisibleSecurityStateChangedEvent.class);
  }

  public Disposable onSecurityStateChanged(Consumer<SecurityStateChangedEvent> listener) {
    return session.subscribe("Security.securityStateChanged", listener, SecurityStateChangedEvent.class);
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetIgnoreCertificateErrorsRequest {
    /**
     * If true, all certificate errors will be ignored.
     */
    private final Boolean ignore;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class HandleCertificateErrorRequest {
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
  public static class SetOverrideCertificateErrorsRequest {
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
  public static class CertificateErrorEvent {
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
  public static class VisibleSecurityStateChangedEvent {
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
  public static class SecurityStateChangedEvent {
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
