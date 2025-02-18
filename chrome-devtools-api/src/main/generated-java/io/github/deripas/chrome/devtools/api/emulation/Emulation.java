package io.github.deripas.chrome.devtools.api.emulation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.github.deripas.chrome.devtools.api.Disposable;
import io.github.deripas.chrome.devtools.api.dom.RGBA;
import io.github.deripas.chrome.devtools.api.network.TimeSinceEpoch;
import io.github.deripas.chrome.devtools.api.page.Viewport;
import java.lang.Boolean;
import java.lang.Deprecated;
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

/**
 * This domain emulates different environments for the page.
 */
@Generated
public interface Emulation {
  /**
   * Tells whether emulation is supported.
   */
  @Deprecated
  CompletableFuture<CanEmulateResponse> canEmulate();

  /**
   * Clears the overridden device metrics.
   */
  CompletableFuture<Void> clearDeviceMetricsOverride();

  /**
   * Clears the overridden Geolocation Position and Error.
   */
  CompletableFuture<Void> clearGeolocationOverride();

  /**
   * Requests that page scale factor is reset to initial values.
   */
  CompletableFuture<Void> resetPageScaleFactor();

  /**
   * Enables or disables simulating a focused and active page.
   */
  CompletableFuture<Void> setFocusEmulationEnabled(SetFocusEmulationEnabledRequest request);

  /**
   * Automatically render all web contents using a dark theme.
   */
  CompletableFuture<Void> setAutoDarkModeOverride(SetAutoDarkModeOverrideRequest request);

  /**
   * Enables CPU throttling to emulate slow CPUs.
   */
  CompletableFuture<Void> setCPUThrottlingRate(SetCPUThrottlingRateRequest request);

  /**
   * Sets or clears an override of the default background color of the frame. This override is used
   * if the content does not specify one.
   */
  CompletableFuture<Void> setDefaultBackgroundColorOverride(
      SetDefaultBackgroundColorOverrideRequest request);

  /**
   * Overrides the values of device screen dimensions (window.screen.width, window.screen.height,
   * window.innerWidth, window.innerHeight, and "device-width"/"device-height"-related CSS media
   * query results).
   */
  CompletableFuture<Void> setDeviceMetricsOverride(SetDeviceMetricsOverrideRequest request);

  /**
   * Start reporting the given posture value to the Device Posture API.
   * This override can also be set in setDeviceMetricsOverride().
   */
  CompletableFuture<Void> setDevicePostureOverride(SetDevicePostureOverrideRequest request);

  /**
   * Clears a device posture override set with either setDeviceMetricsOverride()
   * or setDevicePostureOverride() and starts using posture information from the
   * platform again.
   * Does nothing if no override is set.
   */
  CompletableFuture<Void> clearDevicePostureOverride();

  CompletableFuture<Void> setScrollbarsHidden(SetScrollbarsHiddenRequest request);

  CompletableFuture<Void> setDocumentCookieDisabled(SetDocumentCookieDisabledRequest request);

  CompletableFuture<Void> setEmitTouchEventsForMouse(SetEmitTouchEventsForMouseRequest request);

  /**
   * Emulates the given media type or media feature for CSS media queries.
   */
  CompletableFuture<Void> setEmulatedMedia(SetEmulatedMediaRequest request);

  /**
   * Emulates the given vision deficiency.
   */
  CompletableFuture<Void> setEmulatedVisionDeficiency(SetEmulatedVisionDeficiencyRequest request);

  /**
   * Overrides the Geolocation Position or Error. Omitting any of the parameters emulates position
   * unavailable.
   */
  CompletableFuture<Void> setGeolocationOverride(SetGeolocationOverrideRequest request);

  CompletableFuture<GetOverriddenSensorInformationResponse> getOverriddenSensorInformation(
      GetOverriddenSensorInformationRequest request);

  /**
   * Overrides a platform sensor of a given type. If |enabled| is true, calls to
   * Sensor.start() will use a virtual sensor as backend rather than fetching
   * data from a real hardware sensor. Otherwise, existing virtual
   * sensor-backend Sensor objects will fire an error event and new calls to
   * Sensor.start() will attempt to use a real sensor instead.
   */
  CompletableFuture<Void> setSensorOverrideEnabled(SetSensorOverrideEnabledRequest request);

  /**
   * Updates the sensor readings reported by a sensor type previously overridden
   * by setSensorOverrideEnabled.
   */
  CompletableFuture<Void> setSensorOverrideReadings(SetSensorOverrideReadingsRequest request);

  /**
   * Overrides a pressure source of a given type, as used by the Compute
   * Pressure API, so that updates to PressureObserver.observe() are provided
   * via setPressureStateOverride instead of being retrieved from
   * platform-provided telemetry data.
   */
  CompletableFuture<Void> setPressureSourceOverrideEnabled(
      SetPressureSourceOverrideEnabledRequest request);

  /**
   * Provides a given pressure state that will be processed and eventually be
   * delivered to PressureObserver users. |source| must have been previously
   * overridden by setPressureSourceOverrideEnabled.
   */
  CompletableFuture<Void> setPressureStateOverride(SetPressureStateOverrideRequest request);

  /**
   * Overrides the Idle state.
   */
  CompletableFuture<Void> setIdleOverride(SetIdleOverrideRequest request);

  /**
   * Clears Idle state overrides.
   */
  CompletableFuture<Void> clearIdleOverride();

  /**
   * Overrides value returned by the javascript navigator object.
   */
  @Deprecated
  CompletableFuture<Void> setNavigatorOverrides(SetNavigatorOverridesRequest request);

  /**
   * Sets a specified page scale factor.
   */
  CompletableFuture<Void> setPageScaleFactor(SetPageScaleFactorRequest request);

  /**
   * Switches script execution in the page.
   */
  CompletableFuture<Void> setScriptExecutionDisabled(SetScriptExecutionDisabledRequest request);

  /**
   * Enables touch on platforms which do not support them.
   */
  CompletableFuture<Void> setTouchEmulationEnabled(SetTouchEmulationEnabledRequest request);

  /**
   * Turns on virtual time for all frames (replacing real-time with a synthetic time source) and sets
   * the current virtual time policy.  Note this supersedes any previous time budget.
   */
  CompletableFuture<SetVirtualTimePolicyResponse> setVirtualTimePolicy(
      SetVirtualTimePolicyRequest request);

  /**
   * Overrides default host system locale with the specified one.
   */
  CompletableFuture<Void> setLocaleOverride(SetLocaleOverrideRequest request);

  /**
   * Overrides default host system timezone with the specified one.
   */
  CompletableFuture<Void> setTimezoneOverride(SetTimezoneOverrideRequest request);

  /**
   * Resizes the frame/viewport of the page. Note that this does not affect the frame's container
   * (e.g. browser window). Can be used to produce screenshots of the specified size. Not supported
   * on Android.
   */
  @Deprecated
  CompletableFuture<Void> setVisibleSize(SetVisibleSizeRequest request);

  CompletableFuture<Void> setDisabledImageTypes(SetDisabledImageTypesRequest request);

  CompletableFuture<Void> setHardwareConcurrencyOverride(
      SetHardwareConcurrencyOverrideRequest request);

  /**
   * Allows overriding user agent with the given string.
   * `userAgentMetadata` must be set for Client Hint headers to be sent.
   */
  CompletableFuture<Void> setUserAgentOverride(SetUserAgentOverrideRequest request);

  /**
   * Allows overriding the automation flag.
   */
  CompletableFuture<Void> setAutomationOverride(SetAutomationOverrideRequest request);

  Disposable onVirtualTimeBudgetExpired(Consumer<VirtualTimeBudgetExpiredEvent> listener);

  @Data
  @Builder(
      toBuilder = true
  )
  class CanEmulateResponse {
    /**
     * True if emulation is supported.
     */
    private final Boolean result;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetFocusEmulationEnabledRequest {
    /**
     * Whether to enable to disable focus emulation.
     */
    private final Boolean enabled;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetAutoDarkModeOverrideRequest {
    /**
     * Whether to enable or disable automatic dark mode.
     * If not specified, any existing override will be cleared.
     */
    @Nullable
    private final Boolean enabled;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetCPUThrottlingRateRequest {
    /**
     * Throttling rate as a slowdown factor (1 is no throttle, 2 is 2x slowdown, etc).
     */
    private final Double rate;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetDefaultBackgroundColorOverrideRequest {
    /**
     * RGBA of the default background color. If not specified, any existing override will be
     * cleared.
     */
    @Nullable
    private final RGBA color;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetDeviceMetricsOverrideRequest {
    /**
     * Overriding width value in pixels (minimum 0, maximum 10000000). 0 disables the override.
     */
    private final Integer width;

    /**
     * Overriding height value in pixels (minimum 0, maximum 10000000). 0 disables the override.
     */
    private final Integer height;

    /**
     * Overriding device scale factor value. 0 disables the override.
     */
    private final Double deviceScaleFactor;

    /**
     * Whether to emulate mobile device. This includes viewport meta tag, overlay scrollbars, text
     * autosizing and more.
     */
    private final Boolean mobile;

    /**
     * Scale to apply to resulting view image.
     */
    @Nullable
    @Experimental
    private final Double scale;

    /**
     * Overriding screen width value in pixels (minimum 0, maximum 10000000).
     */
    @Nullable
    @Experimental
    private final Integer screenWidth;

    /**
     * Overriding screen height value in pixels (minimum 0, maximum 10000000).
     */
    @Nullable
    @Experimental
    private final Integer screenHeight;

    /**
     * Overriding view X position on screen in pixels (minimum 0, maximum 10000000).
     */
    @Nullable
    @Experimental
    private final Integer positionX;

    /**
     * Overriding view Y position on screen in pixels (minimum 0, maximum 10000000).
     */
    @Nullable
    @Experimental
    private final Integer positionY;

    /**
     * Do not set visible view size, rely upon explicit setVisibleSize call.
     */
    @Nullable
    @Experimental
    private final Boolean dontSetVisibleSize;

    /**
     * Screen orientation override.
     */
    @Nullable
    private final ScreenOrientation screenOrientation;

    /**
     * If set, the visible area of the page will be overridden to this viewport. This viewport
     * change is not observed by the page, e.g. viewport-relative elements do not change positions.
     */
    @Nullable
    @Experimental
    private final Viewport viewport;

    /**
     * If set, the display feature of a multi-segment screen. If not set, multi-segment support
     * is turned-off.
     */
    @Nullable
    @Experimental
    private final DisplayFeature displayFeature;

    /**
     * If set, the posture of a foldable device. If not set the posture is set
     * to continuous.
     * Deprecated, use Emulation.setDevicePostureOverride.
     */
    @Nullable
    @Experimental
    @Deprecated
    private final DevicePosture devicePosture;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetDevicePostureOverrideRequest {
    private final DevicePosture posture;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetScrollbarsHiddenRequest {
    /**
     * Whether scrollbars should be always hidden.
     */
    private final Boolean hidden;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetDocumentCookieDisabledRequest {
    /**
     * Whether document.coookie API should be disabled.
     */
    private final Boolean disabled;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetEmitTouchEventsForMouseRequest {
    /**
     * Whether touch emulation based on mouse input should be enabled.
     */
    private final Boolean enabled;

    /**
     * Touch/gesture events configuration. Default: current platform.
     */
    @Nullable
    private final Configuration configuration;

    public enum Configuration {
      @JsonProperty("mobile")
      MOBILE,

      @JsonProperty("desktop")
      DESKTOP
    }
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetEmulatedMediaRequest {
    /**
     * Media type to emulate. Empty string disables the override.
     */
    @Nullable
    private final String media;

    /**
     * Media features to emulate.
     */
    @Nullable
    private final List<MediaFeature> features;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetEmulatedVisionDeficiencyRequest {
    /**
     * Vision deficiency to emulate. Order: best-effort emulations come first, followed by any
     * physiologically accurate emulations for medically recognized color vision deficiencies.
     */
    private final Type type;

    public enum Type {
      @JsonProperty("none")
      NONE,

      @JsonProperty("blurredVision")
      BLURRED_VISION,

      @JsonProperty("reducedContrast")
      REDUCED_CONTRAST,

      @JsonProperty("achromatopsia")
      ACHROMATOPSIA,

      @JsonProperty("deuteranopia")
      DEUTERANOPIA,

      @JsonProperty("protanopia")
      PROTANOPIA,

      @JsonProperty("tritanopia")
      TRITANOPIA
    }
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetGeolocationOverrideRequest {
    /**
     * Mock latitude
     */
    @Nullable
    private final Double latitude;

    /**
     * Mock longitude
     */
    @Nullable
    private final Double longitude;

    /**
     * Mock accuracy
     */
    @Nullable
    private final Double accuracy;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetOverriddenSensorInformationRequest {
    private final SensorType type;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetOverriddenSensorInformationResponse {
    private final Double requestedSamplingFrequency;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetSensorOverrideEnabledRequest {
    private final Boolean enabled;

    private final SensorType type;

    @Nullable
    private final SensorMetadata metadata;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetSensorOverrideReadingsRequest {
    private final SensorType type;

    private final SensorReading reading;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetPressureSourceOverrideEnabledRequest {
    private final Boolean enabled;

    private final PressureSource source;

    @Nullable
    private final PressureMetadata metadata;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetPressureStateOverrideRequest {
    private final PressureSource source;

    private final PressureState state;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetIdleOverrideRequest {
    /**
     * Mock isUserActive
     */
    private final Boolean isUserActive;

    /**
     * Mock isScreenUnlocked
     */
    private final Boolean isScreenUnlocked;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetNavigatorOverridesRequest {
    /**
     * The platform navigator.platform should return.
     */
    private final String platform;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetPageScaleFactorRequest {
    /**
     * Page scale factor.
     */
    private final Double pageScaleFactor;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetScriptExecutionDisabledRequest {
    /**
     * Whether script execution should be disabled in the page.
     */
    private final Boolean value;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetTouchEmulationEnabledRequest {
    /**
     * Whether the touch event emulation should be enabled.
     */
    private final Boolean enabled;

    /**
     * Maximum touch points supported. Defaults to one.
     */
    @Nullable
    private final Integer maxTouchPoints;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetVirtualTimePolicyRequest {
    private final VirtualTimePolicy policy;

    /**
     * If set, after this many virtual milliseconds have elapsed virtual time will be paused and a
     * virtualTimeBudgetExpired event is sent.
     */
    @Nullable
    private final Double budget;

    /**
     * If set this specifies the maximum number of tasks that can be run before virtual is forced
     * forwards to prevent deadlock.
     */
    @Nullable
    private final Integer maxVirtualTimeTaskStarvationCount;

    /**
     * If set, base::Time::Now will be overridden to initially return this value.
     */
    @Nullable
    private final TimeSinceEpoch initialVirtualTime;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetVirtualTimePolicyResponse {
    /**
     * Absolute timestamp at which virtual time was first enabled (up time in milliseconds).
     */
    private final Double virtualTimeTicksBase;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetLocaleOverrideRequest {
    /**
     * ICU style C locale (e.g. "en_US"). If not specified or empty, disables the override and
     * restores default host system locale.
     */
    @Nullable
    private final String locale;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetTimezoneOverrideRequest {
    /**
     * The timezone identifier. List of supported timezones:
     * https://source.chromium.org/chromium/chromium/deps/icu.git/+/faee8bc70570192d82d2978a71e2a615788597d1:source/data/misc/metaZones.txt
     * If empty, disables the override and restores default host system timezone.
     */
    private final String timezoneId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetVisibleSizeRequest {
    /**
     * Frame width (DIP).
     */
    private final Integer width;

    /**
     * Frame height (DIP).
     */
    private final Integer height;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetDisabledImageTypesRequest {
    /**
     * Image types to disable.
     */
    private final List<DisabledImageType> imageTypes;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetHardwareConcurrencyOverrideRequest {
    /**
     * Hardware concurrency to report
     */
    private final Integer hardwareConcurrency;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetUserAgentOverrideRequest {
    /**
     * User agent to use.
     */
    private final String userAgent;

    /**
     * Browser language to emulate.
     */
    @Nullable
    private final String acceptLanguage;

    /**
     * The platform navigator.platform should return.
     */
    @Nullable
    private final String platform;

    /**
     * To be sent in Sec-CH-UA-* headers and returned in navigator.userAgentData
     */
    @Nullable
    @Experimental
    private final UserAgentMetadata userAgentMetadata;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetAutomationOverrideRequest {
    /**
     * Whether the override should be enabled.
     */
    private final Boolean enabled;
  }

  /**
   * Notification sent after the virtual time budget for the current VirtualTimePolicy has run out.
   */
  @JsonTypeName("virtualTimeBudgetExpired")
  class VirtualTimeBudgetExpiredEvent {
  }
}
