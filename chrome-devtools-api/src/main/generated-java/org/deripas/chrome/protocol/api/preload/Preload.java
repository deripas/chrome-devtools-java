package org.deripas.chrome.protocol.api.preload;

import com.fasterxml.jackson.annotation.JsonTypeName;
import java.lang.Boolean;
import java.lang.String;
import java.lang.Void;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.Disposable;
import org.deripas.chrome.protocol.api.network.LoaderId;
import org.deripas.chrome.protocol.api.network.RequestId;
import org.deripas.chrome.protocol.api.page.FrameId;

@Experimental
@Generated
public interface Preload {
  CompletableFuture<Void> enable();

  CompletableFuture<Void> disable();

  Disposable onRuleSetUpdated(Consumer<RuleSetUpdatedEvent> listener);

  Disposable onRuleSetRemoved(Consumer<RuleSetRemovedEvent> listener);

  Disposable onPreloadEnabledStateUpdated(Consumer<PreloadEnabledStateUpdatedEvent> listener);

  Disposable onPrefetchStatusUpdated(Consumer<PrefetchStatusUpdatedEvent> listener);

  Disposable onPrerenderStatusUpdated(Consumer<PrerenderStatusUpdatedEvent> listener);

  Disposable onPreloadingAttemptSourcesUpdated(
      Consumer<PreloadingAttemptSourcesUpdatedEvent> listener);

  /**
   * Upsert. Currently, it is only emitted when a rule set added.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("ruleSetUpdated")
  class RuleSetUpdatedEvent {
    private final RuleSet ruleSet;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("ruleSetRemoved")
  class RuleSetRemovedEvent {
    private final RuleSetId id;
  }

  /**
   * Fired when a preload enabled state is updated.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("preloadEnabledStateUpdated")
  class PreloadEnabledStateUpdatedEvent {
    private final Boolean disabledByPreference;

    private final Boolean disabledByDataSaver;

    private final Boolean disabledByBatterySaver;

    private final Boolean disabledByHoldbackPrefetchSpeculationRules;

    private final Boolean disabledByHoldbackPrerenderSpeculationRules;
  }

  /**
   * Fired when a prefetch attempt is updated.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("prefetchStatusUpdated")
  class PrefetchStatusUpdatedEvent {
    private final PreloadingAttemptKey key;

    private final PreloadPipelineId pipelineId;

    /**
     * The frame id of the frame initiating prefetch.
     */
    private final FrameId initiatingFrameId;

    private final String prefetchUrl;

    private final PreloadingStatus status;

    private final PrefetchStatus prefetchStatus;

    private final RequestId requestId;
  }

  /**
   * Fired when a prerender attempt is updated.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("prerenderStatusUpdated")
  class PrerenderStatusUpdatedEvent {
    private final PreloadingAttemptKey key;

    private final PreloadPipelineId pipelineId;

    private final PreloadingStatus status;

    @Nullable
    private final PrerenderFinalStatus prerenderStatus;

    /**
     * This is used to give users more information about the name of Mojo interface
     * that is incompatible with prerender and has caused the cancellation of the attempt.
     */
    @Nullable
    private final String disallowedMojoInterface;

    @Nullable
    private final List<PrerenderMismatchedHeaders> mismatchedHeaders;
  }

  /**
   * Send a list of sources for all preloading attempts in a document.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("preloadingAttemptSourcesUpdated")
  class PreloadingAttemptSourcesUpdatedEvent {
    private final LoaderId loaderId;

    private final List<PreloadingAttemptSource> preloadingAttemptSources;
  }
}
