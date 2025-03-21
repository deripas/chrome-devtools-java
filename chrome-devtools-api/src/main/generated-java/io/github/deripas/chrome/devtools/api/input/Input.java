package io.github.deripas.chrome.devtools.api.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.deripas.chrome.devtools.api.Disposable;
import io.github.deripas.chrome.devtools.api.Session;
import java.lang.Boolean;
import java.lang.Double;
import java.lang.Integer;
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
@Generated
public class Input {
  private final Session session;

  /**
   * Dispatches a drag event into the page.
   */
  public CompletableFuture<Void> dispatchDragEvent(DispatchDragEventRequest request) {
    return session.send("Input.dispatchDragEvent", request, Void.class);
  }

  /**
   * Dispatches a key event to the page.
   */
  public CompletableFuture<Void> dispatchKeyEvent(DispatchKeyEventRequest request) {
    return session.send("Input.dispatchKeyEvent", request, Void.class);
  }

  /**
   * This method emulates inserting text that doesn't come from a key press,
   * for example an emoji keyboard or an IME.
   */
  public CompletableFuture<Void> insertText(InsertTextRequest request) {
    return session.send("Input.insertText", request, Void.class);
  }

  /**
   * This method sets the current candidate text for IME.
   * Use imeCommitComposition to commit the final text.
   * Use imeSetComposition with empty string as text to cancel composition.
   */
  public CompletableFuture<Void> imeSetComposition(ImeSetCompositionRequest request) {
    return session.send("Input.imeSetComposition", request, Void.class);
  }

  /**
   * Dispatches a mouse event to the page.
   */
  public CompletableFuture<Void> dispatchMouseEvent(DispatchMouseEventRequest request) {
    return session.send("Input.dispatchMouseEvent", request, Void.class);
  }

  /**
   * Dispatches a touch event to the page.
   */
  public CompletableFuture<Void> dispatchTouchEvent(DispatchTouchEventRequest request) {
    return session.send("Input.dispatchTouchEvent", request, Void.class);
  }

  /**
   * Cancels any active dragging in the page.
   */
  public CompletableFuture<Void> cancelDragging() {
    return session.send("Input.cancelDragging", null, Void.class);
  }

  /**
   * Emulates touch event from the mouse event parameters.
   */
  public CompletableFuture<Void> emulateTouchFromMouseEvent(
      EmulateTouchFromMouseEventRequest request) {
    return session.send("Input.emulateTouchFromMouseEvent", request, Void.class);
  }

  /**
   * Ignores input events (useful while auditing page).
   */
  public CompletableFuture<Void> setIgnoreInputEvents(SetIgnoreInputEventsRequest request) {
    return session.send("Input.setIgnoreInputEvents", request, Void.class);
  }

  /**
   * Prevents default drag and drop behavior and instead emits `Input.dragIntercepted` events.
   * Drag and drop behavior can be directly controlled via `Input.dispatchDragEvent`.
   */
  public CompletableFuture<Void> setInterceptDrags(SetInterceptDragsRequest request) {
    return session.send("Input.setInterceptDrags", request, Void.class);
  }

  /**
   * Synthesizes a pinch gesture over a time period by issuing appropriate touch events.
   */
  public CompletableFuture<Void> synthesizePinchGesture(SynthesizePinchGestureRequest request) {
    return session.send("Input.synthesizePinchGesture", request, Void.class);
  }

  /**
   * Synthesizes a scroll gesture over a time period by issuing appropriate touch events.
   */
  public CompletableFuture<Void> synthesizeScrollGesture(SynthesizeScrollGestureRequest request) {
    return session.send("Input.synthesizeScrollGesture", request, Void.class);
  }

  /**
   * Synthesizes a tap gesture over a time period by issuing appropriate touch events.
   */
  public CompletableFuture<Void> synthesizeTapGesture(SynthesizeTapGestureRequest request) {
    return session.send("Input.synthesizeTapGesture", request, Void.class);
  }

  public Disposable onDragIntercepted(Consumer<DragInterceptedEvent> listener) {
    return session.subscribe("Input.dragIntercepted", listener, DragInterceptedEvent.class);
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class DispatchDragEventRequest {
    /**
     * Type of the drag event.
     */
    private final Type type;

    /**
     * X coordinate of the event relative to the main frame's viewport in CSS pixels.
     */
    private final Double x;

    /**
     * Y coordinate of the event relative to the main frame's viewport in CSS pixels. 0 refers to
     * the top of the viewport and Y increases as it proceeds towards the bottom of the viewport.
     */
    private final Double y;

    private final DragData data;

    /**
     * Bit field representing pressed modifier keys. Alt=1, Ctrl=2, Meta/Command=4, Shift=8
     * (default: 0).
     */
    @Nullable
    private final Integer modifiers;

    public enum Type {
      @JsonProperty("dragEnter")
      DRAG_ENTER,

      @JsonProperty("dragOver")
      DRAG_OVER,

      @JsonProperty("drop")
      DROP,

      @JsonProperty("dragCancel")
      DRAG_CANCEL
    }
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class DispatchKeyEventRequest {
    /**
     * Type of the key event.
     */
    private final Type type;

    /**
     * Bit field representing pressed modifier keys. Alt=1, Ctrl=2, Meta/Command=4, Shift=8
     * (default: 0).
     */
    @Nullable
    private final Integer modifiers;

    /**
     * Time at which the event occurred.
     */
    @Nullable
    private final TimeSinceEpoch timestamp;

    /**
     * Text as generated by processing a virtual key code with a keyboard layout. Not needed for
     * for `keyUp` and `rawKeyDown` events (default: "")
     */
    @Nullable
    private final String text;

    /**
     * Text that would have been generated by the keyboard if no modifiers were pressed (except for
     * shift). Useful for shortcut (accelerator) key handling (default: "").
     */
    @Nullable
    private final String unmodifiedText;

    /**
     * Unique key identifier (e.g., 'U+0041') (default: "").
     */
    @Nullable
    private final String keyIdentifier;

    /**
     * Unique DOM defined string value for each physical key (e.g., 'KeyA') (default: "").
     */
    @Nullable
    private final String code;

    /**
     * Unique DOM defined string value describing the meaning of the key in the context of active
     * modifiers, keyboard layout, etc (e.g., 'AltGr') (default: "").
     */
    @Nullable
    private final String key;

    /**
     * Windows virtual key code (default: 0).
     */
    @Nullable
    private final Integer windowsVirtualKeyCode;

    /**
     * Native virtual key code (default: 0).
     */
    @Nullable
    private final Integer nativeVirtualKeyCode;

    /**
     * Whether the event was generated from auto repeat (default: false).
     */
    @Nullable
    private final Boolean autoRepeat;

    /**
     * Whether the event was generated from the keypad (default: false).
     */
    @Nullable
    private final Boolean isKeypad;

    /**
     * Whether the event was a system key event (default: false).
     */
    @Nullable
    private final Boolean isSystemKey;

    /**
     * Whether the event was from the left or right side of the keyboard. 1=Left, 2=Right (default:
     * 0).
     */
    @Nullable
    private final Integer location;

    /**
     * Editing commands to send with the key event (e.g., 'selectAll') (default: []).
     * These are related to but not equal the command names used in `document.execCommand` and NSStandardKeyBindingResponding.
     * See https://source.chromium.org/chromium/chromium/src/+/main:third_party/blink/renderer/core/editing/commands/editor_command_names.h for valid command names.
     */
    @Nullable
    @Experimental
    private final List<String> commands;

    public enum Type {
      @JsonProperty("keyDown")
      KEY_DOWN,

      @JsonProperty("keyUp")
      KEY_UP,

      @JsonProperty("rawKeyDown")
      RAW_KEY_DOWN,

      @JsonProperty("char")
      CHAR
    }
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class InsertTextRequest {
    /**
     * The text to insert.
     */
    private final String text;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class ImeSetCompositionRequest {
    /**
     * The text to insert
     */
    private final String text;

    /**
     * selection start
     */
    private final Integer selectionStart;

    /**
     * selection end
     */
    private final Integer selectionEnd;

    /**
     * replacement start
     */
    @Nullable
    private final Integer replacementStart;

    /**
     * replacement end
     */
    @Nullable
    private final Integer replacementEnd;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class DispatchMouseEventRequest {
    /**
     * Type of the mouse event.
     */
    private final Type type;

    /**
     * X coordinate of the event relative to the main frame's viewport in CSS pixels.
     */
    private final Double x;

    /**
     * Y coordinate of the event relative to the main frame's viewport in CSS pixels. 0 refers to
     * the top of the viewport and Y increases as it proceeds towards the bottom of the viewport.
     */
    private final Double y;

    /**
     * Bit field representing pressed modifier keys. Alt=1, Ctrl=2, Meta/Command=4, Shift=8
     * (default: 0).
     */
    @Nullable
    private final Integer modifiers;

    /**
     * Time at which the event occurred.
     */
    @Nullable
    private final TimeSinceEpoch timestamp;

    /**
     * Mouse button (default: "none").
     */
    @Nullable
    private final MouseButton button;

    /**
     * A number indicating which buttons are pressed on the mouse when a mouse event is triggered.
     * Left=1, Right=2, Middle=4, Back=8, Forward=16, None=0.
     */
    @Nullable
    private final Integer buttons;

    /**
     * Number of times the mouse button was clicked (default: 0).
     */
    @Nullable
    private final Integer clickCount;

    /**
     * The normalized pressure, which has a range of [0,1] (default: 0).
     */
    @Nullable
    @Experimental
    private final Double force;

    /**
     * The normalized tangential pressure, which has a range of [-1,1] (default: 0).
     */
    @Nullable
    @Experimental
    private final Double tangentialPressure;

    /**
     * The plane angle between the Y-Z plane and the plane containing both the stylus axis and the Y axis, in degrees of the range [-90,90], a positive tiltX is to the right (default: 0).
     */
    @Nullable
    private final Double tiltX;

    /**
     * The plane angle between the X-Z plane and the plane containing both the stylus axis and the X axis, in degrees of the range [-90,90], a positive tiltY is towards the user (default: 0).
     */
    @Nullable
    private final Double tiltY;

    /**
     * The clockwise rotation of a pen stylus around its own major axis, in degrees in the range [0,359] (default: 0).
     */
    @Nullable
    @Experimental
    private final Integer twist;

    /**
     * X delta in CSS pixels for mouse wheel event (default: 0).
     */
    @Nullable
    private final Double deltaX;

    /**
     * Y delta in CSS pixels for mouse wheel event (default: 0).
     */
    @Nullable
    private final Double deltaY;

    /**
     * Pointer type (default: "mouse").
     */
    @Nullable
    private final PointerType pointerType;

    public enum Type {
      @JsonProperty("mousePressed")
      MOUSE_PRESSED,

      @JsonProperty("mouseReleased")
      MOUSE_RELEASED,

      @JsonProperty("mouseMoved")
      MOUSE_MOVED,

      @JsonProperty("mouseWheel")
      MOUSE_WHEEL
    }

    public enum PointerType {
      @JsonProperty("mouse")
      MOUSE,

      @JsonProperty("pen")
      PEN
    }
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class DispatchTouchEventRequest {
    /**
     * Type of the touch event. TouchEnd and TouchCancel must not contain any touch points, while
     * TouchStart and TouchMove must contains at least one.
     */
    private final Type type;

    /**
     * Active touch points on the touch device. One event per any changed point (compared to
     * previous touch event in a sequence) is generated, emulating pressing/moving/releasing points
     * one by one.
     */
    private final List<TouchPoint> touchPoints;

    /**
     * Bit field representing pressed modifier keys. Alt=1, Ctrl=2, Meta/Command=4, Shift=8
     * (default: 0).
     */
    @Nullable
    private final Integer modifiers;

    /**
     * Time at which the event occurred.
     */
    @Nullable
    private final TimeSinceEpoch timestamp;

    public enum Type {
      @JsonProperty("touchStart")
      TOUCH_START,

      @JsonProperty("touchEnd")
      TOUCH_END,

      @JsonProperty("touchMove")
      TOUCH_MOVE,

      @JsonProperty("touchCancel")
      TOUCH_CANCEL
    }
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class EmulateTouchFromMouseEventRequest {
    /**
     * Type of the mouse event.
     */
    private final Type type;

    /**
     * X coordinate of the mouse pointer in DIP.
     */
    private final Integer x;

    /**
     * Y coordinate of the mouse pointer in DIP.
     */
    private final Integer y;

    /**
     * Mouse button. Only "none", "left", "right" are supported.
     */
    private final MouseButton button;

    /**
     * Time at which the event occurred (default: current time).
     */
    @Nullable
    private final TimeSinceEpoch timestamp;

    /**
     * X delta in DIP for mouse wheel event (default: 0).
     */
    @Nullable
    private final Double deltaX;

    /**
     * Y delta in DIP for mouse wheel event (default: 0).
     */
    @Nullable
    private final Double deltaY;

    /**
     * Bit field representing pressed modifier keys. Alt=1, Ctrl=2, Meta/Command=4, Shift=8
     * (default: 0).
     */
    @Nullable
    private final Integer modifiers;

    /**
     * Number of times the mouse button was clicked (default: 0).
     */
    @Nullable
    private final Integer clickCount;

    public enum Type {
      @JsonProperty("mousePressed")
      MOUSE_PRESSED,

      @JsonProperty("mouseReleased")
      MOUSE_RELEASED,

      @JsonProperty("mouseMoved")
      MOUSE_MOVED,

      @JsonProperty("mouseWheel")
      MOUSE_WHEEL
    }
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetIgnoreInputEventsRequest {
    /**
     * Ignores input events processing when set to true.
     */
    private final Boolean ignore;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetInterceptDragsRequest {
    private final Boolean enabled;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SynthesizePinchGestureRequest {
    /**
     * X coordinate of the start of the gesture in CSS pixels.
     */
    private final Double x;

    /**
     * Y coordinate of the start of the gesture in CSS pixels.
     */
    private final Double y;

    /**
     * Relative scale factor after zooming (&gt;1.0 zooms in, &lt;1.0 zooms out).
     */
    private final Double scaleFactor;

    /**
     * Relative pointer speed in pixels per second (default: 800).
     */
    @Nullable
    private final Integer relativeSpeed;

    /**
     * Which type of input events to be generated (default: 'default', which queries the platform
     * for the preferred input type).
     */
    @Nullable
    private final GestureSourceType gestureSourceType;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SynthesizeScrollGestureRequest {
    /**
     * X coordinate of the start of the gesture in CSS pixels.
     */
    private final Double x;

    /**
     * Y coordinate of the start of the gesture in CSS pixels.
     */
    private final Double y;

    /**
     * The distance to scroll along the X axis (positive to scroll left).
     */
    @Nullable
    private final Double xDistance;

    /**
     * The distance to scroll along the Y axis (positive to scroll up).
     */
    @Nullable
    private final Double yDistance;

    /**
     * The number of additional pixels to scroll back along the X axis, in addition to the given
     * distance.
     */
    @Nullable
    private final Double xOverscroll;

    /**
     * The number of additional pixels to scroll back along the Y axis, in addition to the given
     * distance.
     */
    @Nullable
    private final Double yOverscroll;

    /**
     * Prevent fling (default: true).
     */
    @Nullable
    private final Boolean preventFling;

    /**
     * Swipe speed in pixels per second (default: 800).
     */
    @Nullable
    private final Integer speed;

    /**
     * Which type of input events to be generated (default: 'default', which queries the platform
     * for the preferred input type).
     */
    @Nullable
    private final GestureSourceType gestureSourceType;

    /**
     * The number of times to repeat the gesture (default: 0).
     */
    @Nullable
    private final Integer repeatCount;

    /**
     * The number of milliseconds delay between each repeat. (default: 250).
     */
    @Nullable
    private final Integer repeatDelayMs;

    /**
     * The name of the interaction markers to generate, if not empty (default: "").
     */
    @Nullable
    private final String interactionMarkerName;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SynthesizeTapGestureRequest {
    /**
     * X coordinate of the start of the gesture in CSS pixels.
     */
    private final Double x;

    /**
     * Y coordinate of the start of the gesture in CSS pixels.
     */
    private final Double y;

    /**
     * Duration between touchdown and touchup events in ms (default: 50).
     */
    @Nullable
    private final Integer duration;

    /**
     * Number of times to perform the tap (e.g. 2 for double tap, default: 1).
     */
    @Nullable
    private final Integer tapCount;

    /**
     * Which type of input events to be generated (default: 'default', which queries the platform
     * for the preferred input type).
     */
    @Nullable
    private final GestureSourceType gestureSourceType;
  }

  /**
   * Emitted only when `Input.setInterceptDrags` is enabled. Use this data with `Input.dispatchDragEvent` to
   * restore normal drag and drop behavior.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class DragInterceptedEvent {
    private final DragData data;
  }
}
