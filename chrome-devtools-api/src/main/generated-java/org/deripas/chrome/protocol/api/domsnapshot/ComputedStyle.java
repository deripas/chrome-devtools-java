package org.deripas.chrome.protocol.api.domsnapshot;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * A subset of the full ComputedStyle as defined by the request whitelist.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ComputedStyle {
  /**
   * Name/value pairs of computed style properties.
   */
  private final List<NameValue> properties;
}
