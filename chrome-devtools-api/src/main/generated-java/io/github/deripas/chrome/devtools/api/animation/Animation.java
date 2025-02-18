package io.github.deripas.chrome.devtools.api.animation;

import com.fasterxml.jackson.annotation.JsonTypeName;
import java.lang.Boolean;
import java.lang.Double;
import java.lang.String;
import java.lang.Void;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import io.github.deripas.chrome.devtools.api.Disposable;
import io.github.deripas.chrome.devtools.api.runtime.RemoteObject;

@Experimental
@Generated
public interface Animation {
  /**
   * Disables animation domain notifications.
   */
  CompletableFuture<Void> disable();

  /**
   * Enables animation domain notifications.
   */
  CompletableFuture<Void> enable();

  /**
   * Returns the current time of the an animation.
   */
  CompletableFuture<GetCurrentTimeResponse> getCurrentTime(GetCurrentTimeRequest request);

  /**
   * Gets the playback rate of the document timeline.
   */
  CompletableFuture<GetPlaybackRateResponse> getPlaybackRate();

  /**
   * Releases a set of animations to no longer be manipulated.
   */
  CompletableFuture<Void> releaseAnimations(ReleaseAnimationsRequest request);

  /**
   * Gets the remote object of the Animation.
   */
  CompletableFuture<ResolveAnimationResponse> resolveAnimation(ResolveAnimationRequest request);

  /**
   * Seek a set of animations to a particular time within each animation.
   */
  CompletableFuture<Void> seekAnimations(SeekAnimationsRequest request);

  /**
   * Sets the paused state of a set of animations.
   */
  CompletableFuture<Void> setPaused(SetPausedRequest request);

  /**
   * Sets the playback rate of the document timeline.
   */
  CompletableFuture<Void> setPlaybackRate(SetPlaybackRateRequest request);

  /**
   * Sets the timing of an animation node.
   */
  CompletableFuture<Void> setTiming(SetTimingRequest request);

  Disposable onAnimationCanceled(Consumer<AnimationCanceledEvent> listener);

  Disposable onAnimationCreated(Consumer<AnimationCreatedEvent> listener);

  Disposable onAnimationStarted(Consumer<AnimationStartedEvent> listener);

  Disposable onAnimationUpdated(Consumer<AnimationUpdatedEvent> listener);

  @Data
  @Builder(
      toBuilder = true
  )
  class GetCurrentTimeRequest {
    /**
     * Id of animation.
     */
    private final String id;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetCurrentTimeResponse {
    /**
     * Current time of the page.
     */
    private final Double currentTime;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetPlaybackRateResponse {
    /**
     * Playback rate for animations on page.
     */
    private final Double playbackRate;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class ReleaseAnimationsRequest {
    /**
     * List of animation ids to seek.
     */
    private final List<String> animations;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class ResolveAnimationRequest {
    /**
     * Animation id.
     */
    private final String animationId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class ResolveAnimationResponse {
    /**
     * Corresponding remote object.
     */
    private final RemoteObject remoteObject;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SeekAnimationsRequest {
    /**
     * List of animation ids to seek.
     */
    private final List<String> animations;

    /**
     * Set the current time of each animation.
     */
    private final Double currentTime;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetPausedRequest {
    /**
     * Animations to set the pause state of.
     */
    private final List<String> animations;

    /**
     * Paused state to set to.
     */
    private final Boolean paused;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetPlaybackRateRequest {
    /**
     * Playback rate for animations on page
     */
    private final Double playbackRate;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetTimingRequest {
    /**
     * Animation id.
     */
    private final String animationId;

    /**
     * Duration of the animation.
     */
    private final Double duration;

    /**
     * Delay of the animation.
     */
    private final Double delay;
  }

  /**
   * Event for when an animation has been cancelled.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("animationCanceled")
  class AnimationCanceledEvent {
    /**
     * Id of the animation that was cancelled.
     */
    private final String id;
  }

  /**
   * Event for each animation that has been created.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("animationCreated")
  class AnimationCreatedEvent {
    /**
     * Id of the animation that was created.
     */
    private final String id;
  }

  /**
   * Event for animation that has been started.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("animationStarted")
  class AnimationStartedEvent {
    /**
     * Animation that was started.
     */
    private final Animation animation;
  }

  /**
   * Event for animation that has been updated.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("animationUpdated")
  class AnimationUpdatedEvent {
    /**
     * Animation that was updated.
     */
    private final Animation animation;
  }
}
