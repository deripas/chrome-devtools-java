package io.github.deripas.chrome.devtools.api.network;

import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Post data entry for HTTP request
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class PostDataEntry {
  @Nullable
  private final String bytes;
}
