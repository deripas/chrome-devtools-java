package org.deripas.chrome.protocol.api.animation;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.runtime.RemoteObject;

@Experimental
@Generated
public interface Animation {
  /**
   * Disables animation domain notifications.
   */
  void disable();

  /**
   * Enables animation domain notifications.
   */
  void enable();

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
  void releaseAnimations(ReleaseAnimationsRequest request);

  /**
   * Gets the remote object of the Animation.
   */
  CompletableFuture<ResolveAnimationResponse> resolveAnimation(ResolveAnimationRequest request);

  /**
   * Seek a set of animations to a particular time within each animation.
   */
  void seekAnimations(SeekAnimationsRequest request);

  /**
   * Sets the paused state of a set of animations.
   */
  void setPaused(SetPausedRequest request);

  /**
   * Sets the playback rate of the document timeline.
   */
  void setPlaybackRate(SetPlaybackRateRequest request);

  /**
   * Sets the timing of an animation node.
   */
  void setTiming(SetTimingRequest request);

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
    private final Long currentTime;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetPlaybackRateResponse {
    /**
     * Playback rate for animations on page.
     */
    private final Long playbackRate;
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
    private final Long currentTime;
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
    private final Long playbackRate;
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
    private final Long duration;

    /**
     * Delay of the animation.
     */
    private final Long delay;
  }
}
