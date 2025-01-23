package org.deripas.chrome.protocol.api.page;

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
public class FileHandler {
  private final String action;

  private final String name;

  @Nullable
  private final List<ImageResource> icons;

  /**
   * Mimic a map, name is the key, accepts is the value.
   */
  @Nullable
  private final List<FileFilter> accepts;

  /**
   * Won't repeat the enums, using string for easy comparison. Same as the
   * other enums below.
   */
  private final String launchType;
}
