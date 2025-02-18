package io.github.deripas.chrome.devtools.api.audits;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
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
import io.github.deripas.chrome.devtools.api.Disposable;
import io.github.deripas.chrome.devtools.api.network.RequestId;

/**
 * Audits domain allows investigation of page violations and possible improvements.
 */
@Experimental
@Generated
public interface Audits {
  /**
   * Returns the response body and size if it were re-encoded with the specified settings. Only
   * applies to images.
   */
  CompletableFuture<GetEncodedResponseResponse> getEncodedResponse(
      GetEncodedResponseRequest request);

  /**
   * Disables issues domain, prevents further issues from being reported to the client.
   */
  CompletableFuture<Void> disable();

  /**
   * Enables issues domain, sends the issues collected so far to the client by means of the
   * `issueAdded` event.
   */
  CompletableFuture<Void> enable();

  /**
   * Runs the contrast check for the target page. Found issues are reported
   * using Audits.issueAdded event.
   */
  CompletableFuture<Void> checkContrast(CheckContrastRequest request);

  /**
   * Runs the form issues check for the target page. Found issues are reported
   * using Audits.issueAdded event.
   */
  CompletableFuture<CheckFormsIssuesResponse> checkFormsIssues();

  Disposable onIssueAdded(Consumer<IssueAddedEvent> listener);

  @Data
  @Builder(
      toBuilder = true
  )
  class GetEncodedResponseRequest {
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
  class GetEncodedResponseResponse {
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
  class CheckContrastRequest {
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
  class CheckFormsIssuesResponse {
    private final List<GenericIssueDetails> formIssues;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("issueAdded")
  class IssueAddedEvent {
    private final InspectorIssue issue;
  }
}
