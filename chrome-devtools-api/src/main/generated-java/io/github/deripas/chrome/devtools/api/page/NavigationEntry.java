package io.github.deripas.chrome.devtools.api.page;

import java.lang.Integer;
import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Navigation history entry.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class NavigationEntry {
  /**
   * Unique id of the navigation history entry.
   */
  private final Integer id;

  /**
   * URL of the navigation history entry.
   */
  private final String url;

  /**
   * URL that the user typed in the url bar.
   */
  private final String userTypedURL;

  /**
   * Title of the navigation history entry.
   */
  private final String title;

  /**
   * Transition type.
   */
  private final TransitionType transitionType;
}
