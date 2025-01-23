package org.deripas.chrome.protocol.api.domsnapshot;

import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * A name/value pair.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class NameValue {
  /**
   * Attribute/property name.
   */
  private final String name;

  /**
   * Attribute/property value.
   */
  private final String value;
}
