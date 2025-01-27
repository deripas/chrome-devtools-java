package org.deripas.chrome.protocol.api.webaudio;

import java.lang.Double;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Fields in AudioContext that change in real-time.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ContextRealtimeData {
  /**
   * The current context time in second in BaseAudioContext.
   */
  private final Double currentTime;

  /**
   * The time spent on rendering graph divided by render quantum duration,
   * and multiplied by 100. 100 means the audio renderer reached the full
   * capacity and glitch may occur.
   */
  private final Double renderCapacity;

  /**
   * A running mean of callback interval.
   */
  private final Double callbackIntervalMean;

  /**
   * A running variance of callback interval.
   */
  private final Double callbackIntervalVariance;
}
