package org.deripas.chrome.protocol.api.memory;

import java.lang.Integer;
import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * DOM object counter data.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class DOMCounter {
  /**
   * Object name. Note: object names should be presumed volatile and clients should not expect
   * the returned names to be consistent across runs.
   */
  private final String name;

  /**
   * Object count.
   */
  private final Integer count;
}
