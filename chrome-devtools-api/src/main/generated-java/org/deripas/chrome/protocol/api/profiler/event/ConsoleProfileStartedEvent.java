package org.deripas.chrome.protocol.api.profiler.event;

import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.debugger.Location;

/**
 * Sent when new profile recording is started using console.profile() call.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ConsoleProfileStartedEvent {
  public static final EventId<ConsoleProfileStartedEvent> ID = new EventId<>("Profiler.consoleProfileStarted", ConsoleProfileStartedEvent.class);

  private final String id;

  /**
   * Location of console.profile().
   */
  private final Location location;

  /**
   * Profile title passed as an argument to console.profile().
   */
  @Nullable
  private final String title;
}
