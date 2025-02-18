package io.github.deripas.chrome.devtools.api.css;

import java.lang.String;
import java.util.List;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import io.github.deripas.chrome.devtools.api.dom.PseudoType;

/**
 * CSS rule collection for a single pseudo style.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class PseudoElementMatches {
  /**
   * Pseudo element type.
   */
  private final PseudoType pseudoType;

  /**
   * Pseudo element custom ident.
   */
  @Nullable
  private final String pseudoIdentifier;

  /**
   * Matches of CSS rules applicable to the pseudo style.
   */
  private final List<RuleMatch> matches;
}
