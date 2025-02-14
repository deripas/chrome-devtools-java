package org.deripas.chrome.protocol.api.page;

import java.lang.String;
import java.util.List;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.network.LoaderId;

/**
 * Information about the Frame on the page.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class Frame {
  /**
   * Frame unique identifier.
   */
  private final FrameId id;

  /**
   * Parent frame identifier.
   */
  @Nullable
  private final FrameId parentId;

  /**
   * Identifier of the loader associated with this frame.
   */
  private final LoaderId loaderId;

  /**
   * Frame's name as specified in the tag.
   */
  @Nullable
  private final String name;

  /**
   * Frame document's URL without fragment.
   */
  private final String url;

  /**
   * Frame document's URL fragment including the '#'.
   */
  @Nullable
  @Experimental
  private final String urlFragment;

  /**
   * Frame document's registered domain, taking the public suffixes list into account.
   * Extracted from the Frame's url.
   * Example URLs: http://www.google.com/file.html -> "google.com"
   *               http://a.b.co.uk/file.html      -> "b.co.uk"
   */
  @Experimental
  private final String domainAndRegistry;

  /**
   * Frame document's security origin.
   */
  private final String securityOrigin;

  /**
   * Additional details about the frame document's security origin.
   */
  @Nullable
  @Experimental
  private final SecurityOriginDetails securityOriginDetails;

  /**
   * Frame document's mimeType as determined by the browser.
   */
  private final String mimeType;

  /**
   * If the frame failed to load, this contains the URL that could not be loaded. Note that unlike url above, this URL may contain a fragment.
   */
  @Nullable
  @Experimental
  private final String unreachableUrl;

  /**
   * Indicates whether this frame was tagged as an ad and why.
   */
  @Nullable
  @Experimental
  private final AdFrameStatus adFrameStatus;

  /**
   * Indicates whether the main document is a secure context and explains why that is the case.
   */
  @Experimental
  private final SecureContextType secureContextType;

  /**
   * Indicates whether this is a cross origin isolated context.
   */
  @Experimental
  private final CrossOriginIsolatedContextType crossOriginIsolatedContextType;

  /**
   * Indicated which gated APIs / features are available.
   */
  @Experimental
  private final List<GatedAPIFeatures> gatedAPIFeatures;
}
