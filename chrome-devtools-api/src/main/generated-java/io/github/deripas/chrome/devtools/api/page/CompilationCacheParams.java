package io.github.deripas.chrome.devtools.api.page;

import java.lang.Boolean;
import java.lang.String;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Per-script compilation cache parameters for `Page.produceCompilationCache`
 */
@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class CompilationCacheParams {
  /**
   * The URL of the script to produce a compilation cache entry for.
   */
  private final String url;

  /**
   * A hint to the backend whether eager compilation is recommended.
   * (the actual compilation mode used is upon backend discretion).
   */
  @Nullable
  private final Boolean eager;
}
