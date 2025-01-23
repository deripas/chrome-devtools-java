package org.deripas.chrome.protocol.api.fetch;

import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Response HTTP header entry
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class HeaderEntry {
  private final String name;

  private final String value;
}
