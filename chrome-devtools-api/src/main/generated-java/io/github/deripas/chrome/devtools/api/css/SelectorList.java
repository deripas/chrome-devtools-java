package io.github.deripas.chrome.devtools.api.css;

import java.lang.String;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Selector list data.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class SelectorList {
  /**
   * Selectors in the list.
   */
  private final List<Value> selectors;

  /**
   * Rule selector text.
   */
  private final String text;
}
