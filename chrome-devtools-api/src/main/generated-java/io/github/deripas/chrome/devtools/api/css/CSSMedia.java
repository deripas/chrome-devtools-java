package io.github.deripas.chrome.devtools.api.css;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.String;
import java.util.List;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * CSS media rule descriptor.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class CSSMedia {
  /**
   * Media query text.
   */
  private final String text;

  /**
   * Source of the media query: "mediaRule" if specified by a &commat;media rule, "importRule" if
   * specified by an &commat;import rule, "linkedSheet" if specified by a "media" attribute in a linked
   * stylesheet's LINK tag, "inlineSheet" if specified by a "media" attribute in an inline
   * stylesheet's STYLE tag.
   */
  private final Source source;

  /**
   * URL of the document containing the media query description.
   */
  @Nullable
  private final String sourceURL;

  /**
   * The associated rule (&commat;media or &commat;import) header range in the enclosing stylesheet (if
   * available).
   */
  @Nullable
  private final SourceRange range;

  /**
   * Identifier of the stylesheet containing this object (if exists).
   */
  @Nullable
  private final StyleSheetId styleSheetId;

  /**
   * Array of media queries.
   */
  @Nullable
  private final List<MediaQuery> mediaList;

  public enum Source {
    @JsonProperty("mediaRule")
    MEDIA_RULE,

    @JsonProperty("importRule")
    IMPORT_RULE,

    @JsonProperty("linkedSheet")
    LINKED_SHEET,

    @JsonProperty("inlineSheet")
    INLINE_SHEET
  }
}
