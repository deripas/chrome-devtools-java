package org.deripas.chrome.protocol.api.webaudio;

import com.fasterxml.jackson.annotation.JsonTypeName;
import java.lang.Double;
import java.lang.Void;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.Disposable;

/**
 * This domain allows inspection of Web Audio API.
 * https://webaudio.github.io/web-audio-api/
 */
@Experimental
@Generated
public interface WebAudio {
  /**
   * Enables the WebAudio domain and starts sending context lifetime events.
   */
  CompletableFuture<Void> enable();

  /**
   * Disables the WebAudio domain.
   */
  CompletableFuture<Void> disable();

  /**
   * Fetch the realtime data from the registered contexts.
   */
  CompletableFuture<GetRealtimeDataResponse> getRealtimeData(GetRealtimeDataRequest request);

  Disposable onContextCreated(Consumer<ContextCreatedEvent> listener);

  Disposable onContextWillBeDestroyed(Consumer<ContextWillBeDestroyedEvent> listener);

  Disposable onContextChanged(Consumer<ContextChangedEvent> listener);

  Disposable onAudioListenerCreated(Consumer<AudioListenerCreatedEvent> listener);

  Disposable onAudioListenerWillBeDestroyed(Consumer<AudioListenerWillBeDestroyedEvent> listener);

  Disposable onAudioNodeCreated(Consumer<AudioNodeCreatedEvent> listener);

  Disposable onAudioNodeWillBeDestroyed(Consumer<AudioNodeWillBeDestroyedEvent> listener);

  Disposable onAudioParamCreated(Consumer<AudioParamCreatedEvent> listener);

  Disposable onAudioParamWillBeDestroyed(Consumer<AudioParamWillBeDestroyedEvent> listener);

  Disposable onNodesConnected(Consumer<NodesConnectedEvent> listener);

  Disposable onNodesDisconnected(Consumer<NodesDisconnectedEvent> listener);

  Disposable onNodeParamConnected(Consumer<NodeParamConnectedEvent> listener);

  Disposable onNodeParamDisconnected(Consumer<NodeParamDisconnectedEvent> listener);

  @Data
  @Builder(
      toBuilder = true
  )
  class GetRealtimeDataRequest {
    private final GraphObjectId contextId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetRealtimeDataResponse {
    private final ContextRealtimeData realtimeData;
  }

  /**
   * Notifies that a new BaseAudioContext has been created.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("contextCreated")
  class ContextCreatedEvent {
    private final BaseAudioContext context;
  }

  /**
   * Notifies that an existing BaseAudioContext will be destroyed.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("contextWillBeDestroyed")
  class ContextWillBeDestroyedEvent {
    private final GraphObjectId contextId;
  }

  /**
   * Notifies that existing BaseAudioContext has changed some properties (id stays the same)..
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("contextChanged")
  class ContextChangedEvent {
    private final BaseAudioContext context;
  }

  /**
   * Notifies that the construction of an AudioListener has finished.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("audioListenerCreated")
  class AudioListenerCreatedEvent {
    private final AudioListener listener;
  }

  /**
   * Notifies that a new AudioListener has been created.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("audioListenerWillBeDestroyed")
  class AudioListenerWillBeDestroyedEvent {
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
  @JsonTypeName("audioNodeCreated")
  class AudioNodeCreatedEvent {
    private final AudioNode node;
  }

  /**
   * Notifies that an existing AudioNode has been destroyed.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("audioNodeWillBeDestroyed")
  class AudioNodeWillBeDestroyedEvent {
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
  @JsonTypeName("audioParamCreated")
  class AudioParamCreatedEvent {
    private final AudioParam param;
  }

  /**
   * Notifies that an existing AudioParam has been destroyed.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("audioParamWillBeDestroyed")
  class AudioParamWillBeDestroyedEvent {
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
  @JsonTypeName("nodesConnected")
  class NodesConnectedEvent {
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
  @JsonTypeName("nodesDisconnected")
  class NodesDisconnectedEvent {
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
  @JsonTypeName("nodeParamConnected")
  class NodeParamConnectedEvent {
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
  @JsonTypeName("nodeParamDisconnected")
  class NodeParamDisconnectedEvent {
    private final GraphObjectId contextId;

    private final GraphObjectId sourceId;

    private final GraphObjectId destinationId;

    @Nullable
    private final Double sourceOutputIndex;
  }
}
