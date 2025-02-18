package io.github.deripas.chrome.devtools.api.preload;

import io.github.deripas.chrome.devtools.api.network.LoaderId;
import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * A key that identifies a preloading attempt.
 *
 * The url used is the url specified by the trigger (i.e. the initial URL), and
 * not the final url that is navigated to. For example, prerendering allows
 * same-origin main frame navigations during the attempt, but the attempt is
 * still keyed with the initial URL.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class PreloadingAttemptKey {
  private final LoaderId loaderId;

  private final SpeculationAction action;

  private final String url;

  @Nullable
  private final SpeculationTargetHint targetHint;
}
