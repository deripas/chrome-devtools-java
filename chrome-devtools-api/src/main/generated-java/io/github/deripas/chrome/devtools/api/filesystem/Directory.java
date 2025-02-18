package io.github.deripas.chrome.devtools.api.filesystem;

import java.lang.String;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class Directory {
  private final String name;

  private final List<String> nestedDirectories;

  /**
   * Files that are directly nested under this directory.
   */
  private final List<File> nestedFiles;
}
