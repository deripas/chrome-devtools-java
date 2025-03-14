package io.github.deripas.chrome.devtools.api.browser;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

@Experimental
@Generated
public enum PermissionType {
  @JsonProperty("ar")
  AR,

  @JsonProperty("audioCapture")
  AUDIO_CAPTURE,

  @JsonProperty("automaticFullscreen")
  AUTOMATIC_FULLSCREEN,

  @JsonProperty("backgroundFetch")
  BACKGROUND_FETCH,

  @JsonProperty("backgroundSync")
  BACKGROUND_SYNC,

  @JsonProperty("cameraPanTiltZoom")
  CAMERA_PAN_TILT_ZOOM,

  @JsonProperty("capturedSurfaceControl")
  CAPTURED_SURFACE_CONTROL,

  @JsonProperty("clipboardReadWrite")
  CLIPBOARD_READ_WRITE,

  @JsonProperty("clipboardSanitizedWrite")
  CLIPBOARD_SANITIZED_WRITE,

  @JsonProperty("displayCapture")
  DISPLAY_CAPTURE,

  @JsonProperty("durableStorage")
  DURABLE_STORAGE,

  @JsonProperty("geolocation")
  GEOLOCATION,

  @JsonProperty("handTracking")
  HAND_TRACKING,

  @JsonProperty("idleDetection")
  IDLE_DETECTION,

  @JsonProperty("keyboardLock")
  KEYBOARD_LOCK,

  @JsonProperty("localFonts")
  LOCAL_FONTS,

  @JsonProperty("localNetworkAccess")
  LOCAL_NETWORK_ACCESS,

  @JsonProperty("midi")
  MIDI,

  @JsonProperty("midiSysex")
  MIDI_SYSEX,

  @JsonProperty("nfc")
  NFC,

  @JsonProperty("notifications")
  NOTIFICATIONS,

  @JsonProperty("paymentHandler")
  PAYMENT_HANDLER,

  @JsonProperty("periodicBackgroundSync")
  PERIODIC_BACKGROUND_SYNC,

  @JsonProperty("pointerLock")
  POINTER_LOCK,

  @JsonProperty("protectedMediaIdentifier")
  PROTECTED_MEDIA_IDENTIFIER,

  @JsonProperty("sensors")
  SENSORS,

  @JsonProperty("smartCard")
  SMART_CARD,

  @JsonProperty("speakerSelection")
  SPEAKER_SELECTION,

  @JsonProperty("storageAccess")
  STORAGE_ACCESS,

  @JsonProperty("topLevelStorageAccess")
  TOP_LEVEL_STORAGE_ACCESS,

  @JsonProperty("videoCapture")
  VIDEO_CAPTURE,

  @JsonProperty("vr")
  VR,

  @JsonProperty("wakeLockScreen")
  WAKE_LOCK_SCREEN,

  @JsonProperty("wakeLockSystem")
  WAKE_LOCK_SYSTEM,

  @JsonProperty("webAppInstallation")
  WEB_APP_INSTALLATION,

  @JsonProperty("webPrinting")
  WEB_PRINTING,

  @JsonProperty("windowManagement")
  WINDOW_MANAGEMENT
}
