package org.deripas.chrome.protocol.api.emulation;

import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class MediaFeature {
  private final String name;

  private final String value;
}
