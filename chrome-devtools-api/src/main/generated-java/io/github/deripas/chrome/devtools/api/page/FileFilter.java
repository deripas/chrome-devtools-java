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
public class FileFilter {
  @Nullable
  private final String name;

  @Nullable
  private final List<String> accepts;
}
