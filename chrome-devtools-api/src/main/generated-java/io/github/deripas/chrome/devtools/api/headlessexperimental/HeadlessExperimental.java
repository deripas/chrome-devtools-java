package io.github.deripas.chrome.devtools.api.headlessexperimental;

import io.github.deripas.chrome.devtools.api.Session;
import java.lang.Boolean;
import java.lang.Deprecated;
import java.lang.Double;
import java.lang.String;
import java.lang.Void;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.RequiredArgsConstructor;

/**
 * This domain provides experimental commands only supported in headless mode.
 */
@RequiredArgsConstructor
@Experimental
@Generated
public class HeadlessExperimental {
  private final Session session;

  /**
   * Sends a BeginFrame to the target and returns when the frame was completed. Optionally captures a
   * screenshot from the resulting frame. Requires that the target was created with enabled
   * BeginFrameControl. Designed for use with --run-all-compositor-stages-before-draw, see also
   * https://goo.gle/chrome-headless-rendering for more background.
   */
  public CompletableFuture<BeginFrameResponse> beginFrame(BeginFrameRequest request) {
    return session.send("HeadlessExperimental.beginFrame", request, BeginFrameResponse.class);
  }

  /**
   * Disables headless events for the target.
   */
  @Deprecated
  public CompletableFuture<Void> disable() {
    return session.send("HeadlessExperimental.disable", null, Void.class);
  }

  /**
   * Enables headless events for the target.
   */
  @Deprecated
  public CompletableFuture<Void> enable() {
    return session.send("HeadlessExperimental.enable", null, Void.class);
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class BeginFrameRequest {
    /**
     * Timestamp of this BeginFrame in Renderer TimeTicks (milliseconds of uptime). If not set,
     * the current time will be used.
     */
    @Nullable
    private final Double frameTimeTicks;

    /**
     * The interval between BeginFrames that is reported to the compositor, in milliseconds.
     * Defaults to a 60 frames/second interval, i.e. about 16.666 milliseconds.
     */
    @Nullable
    private final Double interval;

    /**
     * Whether updates should not be committed and drawn onto the display. False by default. If
     * true, only side effects of the BeginFrame will be run, such as layout and animations, but
     * any visual updates may not be visible on the display or in screenshots.
     */
    @Nullable
    private final Boolean noDisplayUpdates;

    /**
     * If set, a screenshot of the frame will be captured and returned in the response. Otherwise,
     * no screenshot will be captured. Note that capturing a screenshot can fail, for example,
     * during renderer initialization. In such a case, no screenshot data will be returned.
     */
    @Nullable
    private final ScreenshotParams screenshot;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class BeginFrameResponse {
    /**
     * Whether the BeginFrame resulted in damage and, thus, a new frame was committed to the
     * display. Reported for diagnostic uses, may be removed in the future.
     */
    private final Boolean hasDamage;

    /**
     * Base64-encoded image data of the screenshot, if one was requested and successfully taken. (Encoded as a base64 string when passed over JSON)
     */
    @Nullable
    private final String screenshotData;
  }
}
