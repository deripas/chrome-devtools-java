package io.github.deripas.chrome.devtools.api.audits;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.deripas.chrome.devtools.api.Disposable;
import io.github.deripas.chrome.devtools.api.Session;
import io.github.deripas.chrome.devtools.api.network.RequestId;
import java.lang.Boolean;
import java.lang.Double;
import java.lang.Integer;
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
 * Audits domain allows investigation of page violations and possible improvements.
 */
@RequiredArgsConstructor
@Experimental
@Generated
public class Audits {
  private final Session session;

  /**
   * Returns the response body and size if it were re-encoded with the specified settings. Only
   * applies to images.
   */
  public CompletableFuture<GetEncodedResponseResponse> getEncodedResponse(
      GetEncodedResponseRequest request) {
    return session.send("Audits.getEncodedResponse", request, GetEncodedResponseResponse.class);
  }

  /**
   * Disables issues domain, prevents further issues from being reported to the client.
   */
  public CompletableFuture<Void> disable() {
    return session.send("Audits.disable", null, Void.class);
  }

  /**
   * Enables issues domain, sends the issues collected so far to the client by means of the
   * `issueAdded` event.
   */
  public CompletableFuture<Void> enable() {
    return session.send("Audits.enable", null, Void.class);
  }

  /**
   * Runs the contrast check for the target page. Found issues are reported
   * using Audits.issueAdded event.
   */
  public CompletableFuture<Void> checkContrast(CheckContrastRequest request) {
    return session.send("Audits.checkContrast", request, Void.class);
  }

  /**
   * Runs the form issues check for the target page. Found issues are reported
   * using Audits.issueAdded event.
   */
  public CompletableFuture<CheckFormsIssuesResponse> checkFormsIssues() {
    return session.send("Audits.checkFormsIssues", null, CheckFormsIssuesResponse.class);
  }

  public Disposable onIssueAdded(Consumer<IssueAddedEvent> listener) {
    return session.subscribe("Audits.issueAdded", listener, IssueAddedEvent.class);
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetEncodedResponseRequest {
    /**
     * Identifier of the network request to get content for.
     */
    private final RequestId requestId;

    /**
     * The encoding to use.
     */
    private final Encoding encoding;

    /**
     * The quality of the encoding (0-1). (defaults to 1)
     */
    @Nullable
    private final Double quality;

    /**
     * Whether to only return the size information (defaults to false).
     */
    @Nullable
    private final Boolean sizeOnly;

    public enum Encoding {
      @JsonProperty("webp")
      WEBP,

      @JsonProperty("jpeg")
      JPEG,

      @JsonProperty("png")
      PNG
    }
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetEncodedResponseResponse {
    /**
     * The encoded body as a base64 string. Omitted if sizeOnly is true. (Encoded as a base64 string when passed over JSON)
     */
    @Nullable
    private final String body;

    /**
     * Size before re-encoding.
     */
    private final Integer originalSize;

    /**
     * Size after re-encoding.
     */
    private final Integer encodedSize;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class CheckContrastRequest {
    /**
     * Whether to report WCAG AAA level issues. Default is false.
     */
    @Nullable
    private final Boolean reportAAA;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class CheckFormsIssuesResponse {
    private final List<GenericIssueDetails> formIssues;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class IssueAddedEvent {
    private final InspectorIssue issue;
  }
}
