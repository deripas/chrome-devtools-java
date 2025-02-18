package io.github.deripas.chrome.devtools.api.cachestorage;

import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class Header {
  private final String name;

  private final String value;
}
