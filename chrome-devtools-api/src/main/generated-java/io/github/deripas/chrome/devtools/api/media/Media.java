package io.github.deripas.chrome.devtools.api.media;

import com.fasterxml.jackson.annotation.JsonTypeName;
import java.lang.Void;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import io.github.deripas.chrome.devtools.api.Disposable;

/**
 * This domain allows detailed inspection of media elements
 */
@Experimental
@Generated
public interface Media {
  /**
   * Enables the Media domain
   */
  CompletableFuture<Void> enable();

  /**
   * Disables the Media domain.
   */
  CompletableFuture<Void> disable();

  Disposable onPlayerPropertiesChanged(Consumer<PlayerPropertiesChangedEvent> listener);

  Disposable onPlayerEventsAdded(Consumer<PlayerEventsAddedEvent> listener);

  Disposable onPlayerMessagesLogged(Consumer<PlayerMessagesLoggedEvent> listener);

  Disposable onPlayerErrorsRaised(Consumer<PlayerErrorsRaisedEvent> listener);

  Disposable onPlayersCreated(Consumer<PlayersCreatedEvent> listener);

  /**
   * This can be called multiple times, and can be used to set / override /
   * remove player properties. A null propValue indicates removal.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("playerPropertiesChanged")
  class PlayerPropertiesChangedEvent {
    private final PlayerId playerId;

    private final List<PlayerProperty> properties;
  }

  /**
   * Send events as a list, allowing them to be batched on the browser for less
   * congestion. If batched, events must ALWAYS be in chronological order.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("playerEventsAdded")
  class PlayerEventsAddedEvent {
    private final PlayerId playerId;

    private final List<PlayerEvent> events;
  }

  /**
   * Send a list of any messages that need to be delivered.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("playerMessagesLogged")
  class PlayerMessagesLoggedEvent {
    private final PlayerId playerId;

    private final List<PlayerMessage> messages;
  }

  /**
   * Send a list of any errors that need to be delivered.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("playerErrorsRaised")
  class PlayerErrorsRaisedEvent {
    private final PlayerId playerId;

    private final List<PlayerError> errors;
  }

  /**
   * Called whenever a player is created, or when a new agent joins and receives
   * a list of active players. If an agent is restored, it will receive the full
   * list of player ids and all events again.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("playersCreated")
  class PlayersCreatedEvent {
    private final List<PlayerId> players;
  }
}
