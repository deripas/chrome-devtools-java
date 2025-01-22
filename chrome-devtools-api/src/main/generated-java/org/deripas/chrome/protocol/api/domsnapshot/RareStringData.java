package org.deripas.chrome.protocol.api.domsnapshot;

import java.lang.Integer;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Data that is only present on rare nodes.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class RareStringData {
  private final List<Integer> index;

  private final List<StringIndex> value;
}
