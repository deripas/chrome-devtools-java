package io.github.deripas.chrome.devtools.api.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Boolean;
import java.lang.Deprecated;
import java.lang.String;
import java.util.List;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import io.github.deripas.chrome.devtools.api.security.MixedContentType;

/**
 * HTTP request data.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class Request {
  /**
   * Request URL (without fragment).
   */
  private final String url;

  /**
   * Fragment of the requested URL starting with hash, if present.
   */
  @Nullable
  private final String urlFragment;

  /**
   * HTTP request method.
   */
  private final String method;

  /**
   * HTTP request headers.
   */
  private final Headers headers;

  /**
   * HTTP POST request data.
   * Use postDataEntries instead.
   */
  @Nullable
  @Deprecated
  private final String postData;

  /**
   * True when the request has POST data. Note that postData might still be omitted when this flag is true when the data is too long.
   */
  @Nullable
  private final Boolean hasPostData;

  /**
   * Request body elements (post data broken into individual entries).
   */
  @Nullable
  @Experimental
  private final List<PostDataEntry> postDataEntries;

  /**
   * The mixed content type of the request.
   */
  @Nullable
  private final MixedContentType mixedContentType;

  /**
   * Priority of the resource request at the time request is sent.
   */
  private final ResourcePriority initialPriority;

  /**
   * The referrer policy of the request, as defined in https://www.w3.org/TR/referrer-policy/
   */
  private final ReferrerPolicy referrerPolicy;

  /**
   * Whether is loaded via link preload.
   */
  @Nullable
  private final Boolean isLinkPreload;

  /**
   * Set for requests when the TrustToken API is used. Contains the parameters
   * passed by the developer (e.g. via "fetch") as understood by the backend.
   */
  @Nullable
  @Experimental
  private final TrustTokenParams trustTokenParams;

  /**
   * True if this resource request is considered to be the 'same site' as the
   * request corresponding to the main frame.
   */
  @Nullable
  @Experimental
  private final Boolean isSameSite;

  public enum ReferrerPolicy {
    @JsonProperty("unsafe-url")
    UNSAFE_URL,

    @JsonProperty("no-referrer-when-downgrade")
    NO_REFERRER_WHEN_DOWNGRADE,

    @JsonProperty("no-referrer")
    NO_REFERRER,

    @JsonProperty("origin")
    ORIGIN,

    @JsonProperty("origin-when-cross-origin")
    ORIGIN_WHEN_CROSS_ORIGIN,

    @JsonProperty("same-origin")
    SAME_ORIGIN,

    @JsonProperty("strict-origin")
    STRICT_ORIGIN,

    @JsonProperty("strict-origin-when-cross-origin")
    STRICT_ORIGIN_WHEN_CROSS_ORIGIN
  }
}
