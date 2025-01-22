package org.deripas.chrome.protocol.api.domsnapshot;

import java.lang.Integer;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class RareIntegerData {
  private final List<Integer> index;

  private final List<Integer> value;
}
