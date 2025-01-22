package org.deripas.chrome.protocol.api.memory;

import java.lang.Long;
import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Executable module information
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class Module {
  /**
   * Name of the module.
   */
  private final String name;

  /**
   * UUID of the module.
   */
  private final String uuid;

  /**
   * Base address where the module is loaded into memory. Encoded as a decimal
   * or hexadecimal (0x prefixed) string.
   */
  private final String baseAddress;

  /**
   * Size of the module in bytes.
   */
  private final Long size;
}
