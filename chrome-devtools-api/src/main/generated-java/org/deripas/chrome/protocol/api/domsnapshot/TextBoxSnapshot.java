package org.deripas.chrome.protocol.api.domsnapshot;

import java.lang.Integer;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Table of details of the post layout rendered text positions. The exact layout should not be regarded as
 * stable and may change between versions.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class TextBoxSnapshot {
  /**
   * Index of the layout tree node that owns this box collection.
   */
  private final List<Integer> layoutIndex;

  /**
   * The absolute position bounding box.
   */
  private final List<Rectangle> bounds;

  /**
   * The starting index in characters, for this post layout textbox substring. Characters that
   * would be represented as a surrogate pair in UTF-16 have length 2.
   */
  private final List<Integer> start;

  /**
   * The number of characters in this post layout textbox substring. Characters that would be
   * represented as a surrogate pair in UTF-16 have length 2.
   */
  private final List<Integer> length;
}
