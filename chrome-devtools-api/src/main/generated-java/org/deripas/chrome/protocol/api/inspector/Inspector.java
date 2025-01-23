package org.deripas.chrome.protocol.api.inspector;

import jdk.jfr.Experimental;
import lombok.Generated;

@Experimental
@Generated
public interface Inspector {
  /**
   * Disables inspector domain notifications.
   */
  void disable();

  /**
   * Enables inspector domain notifications.
   */
  void enable();
}
