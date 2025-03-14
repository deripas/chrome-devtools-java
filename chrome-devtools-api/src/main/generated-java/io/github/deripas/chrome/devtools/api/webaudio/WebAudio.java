package io.github.deripas.chrome.devtools.api.webaudio;

import io.github.deripas.chrome.devtools.api.Disposable;
import io.github.deripas.chrome.devtools.api.Session;
import java.lang.Double;
import java.lang.Void;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.RequiredArgsConstructor;

/**
 * This domain allows inspection of Web Audio API.
 * https://webaudio.github.io/web-audio-api/
 */
@RequiredArgsConstructor
@Experimental
@Generated
public class WebAudio {
  private final Session session;

  /**
   * Enables the WebAudio domain and starts sending context lifetime events.
   */
  public CompletableFuture<Void> enable() {
    return session.send("WebAudio.enable", null, Void.class);
  }

  /**
   * Disables the WebAudio domain.
   */
  public CompletableFuture<Void> disable() {
    return session.send("WebAudio.disable", null, Void.class);
  }

  /**
   * Fetch the realtime data from the registered contexts.
   */
  public CompletableFuture<GetRealtimeDataResponse> getRealtimeData(
      GetRealtimeDataRequest request) {
    return session.send("WebAudio.getRealtimeData", request, GetRealtimeDataResponse.class);
  }

  public Disposable onContextCreated(Consumer<ContextCreatedEvent> listener) {
    return session.subscribe("WebAudio.contextCreated", listener, ContextCreatedEvent.class);
  }

  public Disposable onContextWillBeDestroyed(Consumer<ContextWillBeDestroyedEvent> listener) {
    return session.subscribe("WebAudio.contextWillBeDestroyed", listener, ContextWillBeDestroyedEvent.class);
  }

  public Disposable onContextChanged(Consumer<ContextChangedEvent> listener) {
    return session.subscribe("WebAudio.contextChanged", listener, ContextChangedEvent.class);
  }

  public Disposable onAudioListenerCreated(Consumer<AudioListenerCreatedEvent> listener) {
    return session.subscribe("WebAudio.audioListenerCreated", listener, AudioListenerCreatedEvent.class);
  }

  public Disposable onAudioListenerWillBeDestroyed(
      Consumer<AudioListenerWillBeDestroyedEvent> listener) {
    return session.subscribe("WebAudio.audioListenerWillBeDestroyed", listener, AudioListenerWillBeDestroyedEvent.class);
  }

  public Disposable onAudioNodeCreated(Consumer<AudioNodeCreatedEvent> listener) {
    return session.subscribe("WebAudio.audioNodeCreated", listener, AudioNodeCreatedEvent.class);
  }

  public Disposable onAudioNodeWillBeDestroyed(Consumer<AudioNodeWillBeDestroyedEvent> listener) {
    return session.subscribe("WebAudio.audioNodeWillBeDestroyed", listener, AudioNodeWillBeDestroyedEvent.class);
  }

  public Disposable onAudioParamCreated(Consumer<AudioParamCreatedEvent> listener) {
    return session.subscribe("WebAudio.audioParamCreated", listener, AudioParamCreatedEvent.class);
  }

  public Disposable onAudioParamWillBeDestroyed(Consumer<AudioParamWillBeDestroyedEvent> listener) {
    return session.subscribe("WebAudio.audioParamWillBeDestroyed", listener, AudioParamWillBeDestroyedEvent.class);
  }

  public Disposable onNodesConnected(Consumer<NodesConnectedEvent> listener) {
    return session.subscribe("WebAudio.nodesConnected", listener, NodesConnectedEvent.class);
  }

  public Disposable onNodesDisconnected(Consumer<NodesDisconnectedEvent> listener) {
    return session.subscribe("WebAudio.nodesDisconnected", listener, NodesDisconnectedEvent.class);
  }

  public Disposable onNodeParamConnected(Consumer<NodeParamConnectedEvent> listener) {
    return session.subscribe("WebAudio.nodeParamConnected", listener, NodeParamConnectedEvent.class);
  }

  public Disposable onNodeParamDisconnected(Consumer<NodeParamDisconnectedEvent> listener) {
    return session.subscribe("WebAudio.nodeParamDisconnected", listener, NodeParamDisconnectedEvent.class);
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetRealtimeDataRequest {
    private final GraphObjectId contextId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetRealtimeDataResponse {
    private final ContextRealtimeData realtimeData;
  }

  /**
   * Notifies that a new BaseAudioContext has been created.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class ContextCreatedEvent {
    private final BaseAudioContext context;
  }

  /**
   * Notifies that an existing BaseAudioContext will be destroyed.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class ContextWillBeDestroyedEvent {
    private final GraphObjectId contextId;
  }

  /**
   * Notifies that existing BaseAudioContext has changed some properties (id stays the same)..
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class ContextChangedEvent {
    private final BaseAudioContext context;
  }

  /**
   * Notifies that the construction of an AudioListener has finished.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class AudioListenerCreatedEvent {
    private final AudioListener listener;
  }

  /**
   * Notifies that a new AudioListener has been created.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class AudioListenerWillBeDestroyedEvent {
    private final GraphObjectId contextId;

    private final GraphObjectId listenerId;
  }

  /**
   * Notifies that a new AudioNode has been created.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class AudioNodeCreatedEvent {
    private final AudioNode node;
  }

  /**
   * Notifies that an existing AudioNode has been destroyed.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class AudioNodeWillBeDestroyedEvent {
    private final GraphObjectId contextId;

    private final GraphObjectId nodeId;
  }

  /**
   * Notifies that a new AudioParam has been created.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class AudioParamCreatedEvent {
    private final AudioParam param;
  }

  /**
   * Notifies that an existing AudioParam has been destroyed.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class AudioParamWillBeDestroyedEvent {
    private final GraphObjectId contextId;

    private final GraphObjectId nodeId;

    private final GraphObjectId paramId;
  }

  /**
   * Notifies that two AudioNodes are connected.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class NodesConnectedEvent {
    private final GraphObjectId contextId;

    private final GraphObjectId sourceId;

    private final GraphObjectId destinationId;

    @Nullable
    private final Double sourceOutputIndex;

    @Nullable
    private final Double destinationInputIndex;
  }

  /**
   * Notifies that AudioNodes are disconnected. The destination can be null, and it means all the outgoing connections from the source are disconnected.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class NodesDisconnectedEvent {
    private final GraphObjectId contextId;

    private final GraphObjectId sourceId;

    private final GraphObjectId destinationId;

    @Nullable
    private final Double sourceOutputIndex;

    @Nullable
    private final Double destinationInputIndex;
  }

  /**
   * Notifies that an AudioNode is connected to an AudioParam.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class NodeParamConnectedEvent {
    private final GraphObjectId contextId;

    private final GraphObjectId sourceId;

    private final GraphObjectId destinationId;

    @Nullable
    private final Double sourceOutputIndex;
  }

  /**
   * Notifies that an AudioNode is disconnected to an AudioParam.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class NodeParamDisconnectedEvent {
    private final GraphObjectId contextId;

    private final GraphObjectId sourceId;

    private final GraphObjectId destinationId;

    @Nullable
    private final Double sourceOutputIndex;
  }
}
