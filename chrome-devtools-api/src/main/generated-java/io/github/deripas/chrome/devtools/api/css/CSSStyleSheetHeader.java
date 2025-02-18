package io.github.deripas.chrome.devtools.api.css;

import java.lang.Boolean;
import java.lang.Double;
import java.lang.String;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import io.github.deripas.chrome.devtools.api.dom.BackendNodeId;
import io.github.deripas.chrome.devtools.api.page.FrameId;

/**
 * CSS stylesheet metainformation.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class CSSStyleSheetHeader {
  /**
   * The stylesheet identifier.
   */
  private final StyleSheetId styleSheetId;

  /**
   * Owner frame identifier.
   */
  private final FrameId frameId;

  /**
   * Stylesheet resource URL. Empty if this is a constructed stylesheet created using
   * new CSSStyleSheet() (but non-empty if this is a constructed stylesheet imported
   * as a CSS module script).
   */
  private final String sourceURL;

  /**
   * URL of source map associated with the stylesheet (if any).
   */
  @Nullable
  private final String sourceMapURL;

  /**
   * Stylesheet origin.
   */
  private final StyleSheetOrigin origin;

  /**
   * Stylesheet title.
   */
  private final String title;

  /**
   * The backend id for the owner node of the stylesheet.
   */
  @Nullable
  private final BackendNodeId ownerNode;

  /**
   * Denotes whether the stylesheet is disabled.
   */
  private final Boolean disabled;

  /**
   * Whether the sourceURL field value comes from the sourceURL comment.
   */
  @Nullable
  private final Boolean hasSourceURL;

  /**
   * Whether this stylesheet is created for STYLE tag by parser. This flag is not set for
   * document.written STYLE tags.
   */
  private final Boolean isInline;

  /**
   * Whether this stylesheet is mutable. Inline stylesheets become mutable
   * after they have been modified via CSSOM API.
   * `<link>` element's stylesheets become mutable only if DevTools modifies them.
   * Constructed stylesheets (new CSSStyleSheet()) are mutable immediately after creation.
   */
  private final Boolean isMutable;

  /**
   * True if this stylesheet is created through new CSSStyleSheet() or imported as a
   * CSS module script.
   */
  private final Boolean isConstructed;

  /**
   * Line offset of the stylesheet within the resource (zero based).
   */
  private final Double startLine;

  /**
   * Column offset of the stylesheet within the resource (zero based).
   */
  private final Double startColumn;

  /**
   * Size of the content (in characters).
   */
  private final Double length;

  /**
   * Line offset of the end of the stylesheet within the resource (zero based).
   */
  private final Double endLine;

  /**
   * Column offset of the end of the stylesheet within the resource (zero based).
   */
  private final Double endColumn;

  /**
   * If the style sheet was loaded from a network resource, this indicates when the resource failed to load
   */
  @Nullable
  @Experimental
  private final Boolean loadingFailed;
}
