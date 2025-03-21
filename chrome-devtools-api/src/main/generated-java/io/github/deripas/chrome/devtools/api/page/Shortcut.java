package io.github.deripas.chrome.devtools.api.page;

import java.lang.String;
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
public class Shortcut {
  private final String name;

  private final String url;
}
