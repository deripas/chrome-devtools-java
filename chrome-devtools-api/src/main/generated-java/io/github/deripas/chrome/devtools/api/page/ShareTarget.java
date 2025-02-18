package io.github.deripas.chrome.devtools.api.page;

import java.lang.String;
import java.util.List;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class ShareTarget {
  private final String action;

  private final String method;

  private final String enctype;

  /**
   * Embed the ShareTargetParams
   */
  @Nullable
  private final String title;

  @Nullable
  private final String text;

  @Nullable
  private final String url;

  @Nullable
  private final List<FileFilter> files;
}
