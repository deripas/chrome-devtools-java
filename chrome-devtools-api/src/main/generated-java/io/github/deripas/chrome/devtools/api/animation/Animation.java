package io.github.deripas.chrome.devtools.api.animation;

import io.github.deripas.chrome.devtools.api.Disposable;
import io.github.deripas.chrome.devtools.api.Session;
import io.github.deripas.chrome.devtools.api.runtime.RemoteObject;
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
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Experimental
@Generated
public class Animation {
  private final Session session;

  /**
   * Disables animation domain notifications.
   */
  public CompletableFuture<Void> disable() {
    return session.send("Animation.disable", null, Void.class);
  }

  /**
   * Enables animation domain notifications.
   */
  public CompletableFuture<Void> enable() {
    return session.send("Animation.enable", null, Void.class);
  }

  /**
   * Returns the current time of the an animation.
   */
  public CompletableFuture<GetCurrentTimeResponse> getCurrentTime(GetCurrentTimeRequest request) {
    return session.send("Animation.getCurrentTime", request, GetCurrentTimeResponse.class);
  }

  /**
   * Gets the playback rate of the document timeline.
   */
  public CompletableFuture<GetPlaybackRateResponse> getPlaybackRate() {
    return session.send("Animation.getPlaybackRate", null, GetPlaybackRateResponse.class);
  }

  /**
   * Releases a set of animations to no longer be manipulated.
   */
  public CompletableFuture<Void> releaseAnimations(ReleaseAnimationsRequest request) {
    return session.send("Animation.releaseAnimations", request, Void.class);
  }

  /**
   * Gets the remote object of the Animation.
   */
  public CompletableFuture<ResolveAnimationResponse> resolveAnimation(
      ResolveAnimationRequest request) {
    return session.send("Animation.resolveAnimation", request, ResolveAnimationResponse.class);
  }

  /**
   * Seek a set of animations to a particular time within each animation.
   */
  public CompletableFuture<Void> seekAnimations(SeekAnimationsRequest request) {
    return session.send("Animation.seekAnimations", request, Void.class);
  }

  /**
   * Sets the paused state of a set of animations.
   */
  public CompletableFuture<Void> setPaused(SetPausedRequest request) {
    return session.send("Animation.setPaused", request, Void.class);
  }

  /**
   * Sets the playback rate of the document timeline.
   */
  public CompletableFuture<Void> setPlaybackRate(SetPlaybackRateRequest request) {
    return session.send("Animation.setPlaybackRate", request, Void.class);
  }

  /**
   * Sets the timing of an animation node.
   */
  public CompletableFuture<Void> setTiming(SetTimingRequest request) {
    return session.send("Animation.setTiming", request, Void.class);
  }

  public Disposable onAnimationCanceled(Consumer<AnimationCanceledEvent> listener) {
    return session.subscribe("Animation.animationCanceled", listener, AnimationCanceledEvent.class);
  }

  public Disposable onAnimationCreated(Consumer<AnimationCreatedEvent> listener) {
    return session.subscribe("Animation.animationCreated", listener, AnimationCreatedEvent.class);
  }

  public Disposable onAnimationStarted(Consumer<AnimationStartedEvent> listener) {
    return session.subscribe("Animation.animationStarted", listener, AnimationStartedEvent.class);
  }

  public Disposable onAnimationUpdated(Consumer<AnimationUpdatedEvent> listener) {
    return session.subscribe("Animation.animationUpdated", listener, AnimationUpdatedEvent.class);
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetCurrentTimeRequest {
    /**
     * Id of animation.
     */
    private final String id;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetCurrentTimeResponse {
    /**
     * Current time of the page.
     */
    private final Double currentTime;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetPlaybackRateResponse {
    /**
     * Playback rate for animations on page.
     */
    private final Double playbackRate;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class ReleaseAnimationsRequest {
    /**
     * List of animation ids to seek.
     */
    private final List<String> animations;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class ResolveAnimationRequest {
    /**
     * Animation id.
     */
    private final String animationId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class ResolveAnimationResponse {
    /**
     * Corresponding remote object.
     */
    private final RemoteObject remoteObject;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SeekAnimationsRequest {
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
  public static class SetPausedRequest {
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
  public static class SetPlaybackRateRequest {
    /**
     * Playback rate for animations on page
     */
    private final Double playbackRate;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetTimingRequest {
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
  public static class AnimationCanceledEvent {
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
  public static class AnimationCreatedEvent {
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
  public static class AnimationStartedEvent {
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
  public static class AnimationUpdatedEvent {
    /**
     * Animation that was updated.
     */
    private final Animation animation;
  }
}
