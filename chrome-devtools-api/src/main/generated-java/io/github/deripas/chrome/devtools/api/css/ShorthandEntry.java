package io.github.deripas.chrome.devtools.api.css;

import java.lang.Boolean;
import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class ShorthandEntry {
  /**
   * Shorthand name.
   */
  private final String name;

  /**
   * Shorthand value.
   */
  private final String value;

  /**
   * Whether the property has "!important" annotation (implies `false` if absent).
   */
  @Nullable
  private final Boolean important;
}
