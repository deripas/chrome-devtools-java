package io.github.deripas.chrome.devtools.api.media;

import io.github.deripas.chrome.devtools.api.Disposable;
import io.github.deripas.chrome.devtools.api.Session;
import java.lang.Void;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.RequiredArgsConstructor;

/**
 * This domain allows detailed inspection of media elements
 */
@RequiredArgsConstructor
@Experimental
@Generated
public class Media {
  private final Session session;

  /**
   * Enables the Media domain
   */
  public CompletableFuture<Void> enable() {
    return session.send("Media.enable", null, Void.class);
  }

  /**
   * Disables the Media domain.
   */
  public CompletableFuture<Void> disable() {
    return session.send("Media.disable", null, Void.class);
  }

  public Disposable onPlayerPropertiesChanged(Consumer<PlayerPropertiesChangedEvent> listener) {
    return session.subscribe("Media.playerPropertiesChanged", listener, PlayerPropertiesChangedEvent.class);
  }

  public Disposable onPlayerEventsAdded(Consumer<PlayerEventsAddedEvent> listener) {
    return session.subscribe("Media.playerEventsAdded", listener, PlayerEventsAddedEvent.class);
  }

  public Disposable onPlayerMessagesLogged(Consumer<PlayerMessagesLoggedEvent> listener) {
    return session.subscribe("Media.playerMessagesLogged", listener, PlayerMessagesLoggedEvent.class);
  }

  public Disposable onPlayerErrorsRaised(Consumer<PlayerErrorsRaisedEvent> listener) {
    return session.subscribe("Media.playerErrorsRaised", listener, PlayerErrorsRaisedEvent.class);
  }

  public Disposable onPlayersCreated(Consumer<PlayersCreatedEvent> listener) {
    return session.subscribe("Media.playersCreated", listener, PlayersCreatedEvent.class);
  }

  /**
   * This can be called multiple times, and can be used to set / override /
   * remove player properties. A null propValue indicates removal.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class PlayerPropertiesChangedEvent {
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
  public static class PlayerEventsAddedEvent {
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
  public static class PlayerMessagesLoggedEvent {
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
  public static class PlayerErrorsRaisedEvent {
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
  public static class PlayersCreatedEvent {
    private final List<PlayerId> players;
  }
}
