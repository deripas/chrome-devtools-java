package org.deripas.chrome.protocol.api.css;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Inherited pseudo element matches from pseudos of an ancestor node.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class InheritedPseudoElementMatches {
  /**
   * Matches of pseudo styles from the pseudos of an ancestor node.
   */
  private final List<PseudoElementMatches> pseudoElements;
}
