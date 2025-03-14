package io.github.deripas.chrome.devtools.api.preload;

import io.github.deripas.chrome.devtools.api.Disposable;
import io.github.deripas.chrome.devtools.api.Session;
import io.github.deripas.chrome.devtools.api.network.LoaderId;
import io.github.deripas.chrome.devtools.api.network.RequestId;
import io.github.deripas.chrome.devtools.api.page.FrameId;
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
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Experimental
@Generated
public class Preload {
  private final Session session;

  public CompletableFuture<Void> enable() {
    return session.send("Preload.enable", null, Void.class);
  }

  public CompletableFuture<Void> disable() {
    return session.send("Preload.disable", null, Void.class);
  }

  public Disposable onRuleSetUpdated(Consumer<RuleSetUpdatedEvent> listener) {
    return session.subscribe("Preload.ruleSetUpdated", listener, RuleSetUpdatedEvent.class);
  }

  public Disposable onRuleSetRemoved(Consumer<RuleSetRemovedEvent> listener) {
    return session.subscribe("Preload.ruleSetRemoved", listener, RuleSetRemovedEvent.class);
  }

  public Disposable onPreloadEnabledStateUpdated(
      Consumer<PreloadEnabledStateUpdatedEvent> listener) {
    return session.subscribe("Preload.preloadEnabledStateUpdated", listener, PreloadEnabledStateUpdatedEvent.class);
  }

  public Disposable onPrefetchStatusUpdated(Consumer<PrefetchStatusUpdatedEvent> listener) {
    return session.subscribe("Preload.prefetchStatusUpdated", listener, PrefetchStatusUpdatedEvent.class);
  }

  public Disposable onPrerenderStatusUpdated(Consumer<PrerenderStatusUpdatedEvent> listener) {
    return session.subscribe("Preload.prerenderStatusUpdated", listener, PrerenderStatusUpdatedEvent.class);
  }

  public Disposable onPreloadingAttemptSourcesUpdated(
      Consumer<PreloadingAttemptSourcesUpdatedEvent> listener) {
    return session.subscribe("Preload.preloadingAttemptSourcesUpdated", listener, PreloadingAttemptSourcesUpdatedEvent.class);
  }

  /**
   * Upsert. Currently, it is only emitted when a rule set added.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class RuleSetUpdatedEvent {
    private final RuleSet ruleSet;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class RuleSetRemovedEvent {
    private final RuleSetId id;
  }

  /**
   * Fired when a preload enabled state is updated.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class PreloadEnabledStateUpdatedEvent {
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
  public static class PrefetchStatusUpdatedEvent {
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
  public static class PrerenderStatusUpdatedEvent {
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
  public static class PreloadingAttemptSourcesUpdatedEvent {
    private final LoaderId loaderId;

    private final List<PreloadingAttemptSource> preloadingAttemptSources;
  }
}
