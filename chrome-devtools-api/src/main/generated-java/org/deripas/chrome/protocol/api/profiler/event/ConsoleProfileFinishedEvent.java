package org.deripas.chrome.protocol.api.profiler.event;

import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.debugger.Location;
import org.deripas.chrome.protocol.api.profiler.Profile;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class ConsoleProfileFinishedEvent {
  public static final EventId<ConsoleProfileFinishedEvent> ID = new EventId<>("Profiler.consoleProfileFinished", ConsoleProfileFinishedEvent.class);

  private final String id;

  /**
   * Location of console.profileEnd().
   */
  private final Location location;

  private final Profile profile;

  /**
   * Profile title passed as an argument to console.profile().
   */
  @Nullable
  private final String title;
}
