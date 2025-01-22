package org.deripas.chrome.protocol.api.domsnapshot;

import java.lang.Integer;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.dom.Rect;

/**
 * Details of post layout rendered text positions. The exact layout should not be regarded as
 * stable and may change between versions.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class InlineTextBox {
  /**
   * The bounding box in document coordinates. Note that scroll offset of the document is ignored.
   */
  private final Rect boundingBox;

  /**
   * The starting index in characters, for this post layout textbox substring. Characters that
   * would be represented as a surrogate pair in UTF-16 have length 2.
   */
  private final Integer startCharacterIndex;

  /**
   * The number of characters in this post layout textbox substring. Characters that would be
   * represented as a surrogate pair in UTF-16 have length 2.
   */
  private final Integer numCharacters;
}
