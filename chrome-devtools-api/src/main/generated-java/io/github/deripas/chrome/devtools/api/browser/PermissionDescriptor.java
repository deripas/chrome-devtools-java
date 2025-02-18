package io.github.deripas.chrome.devtools.api.browser;

import java.lang.Boolean;
import java.lang.String;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Definition of PermissionDescriptor defined in the Permissions API:
 * https://w3c.github.io/permissions/#dom-permissiondescriptor.
 */
@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class PermissionDescriptor {
  /**
   * Name of permission.
   * See https://cs.chromium.org/chromium/src/third_party/blink/renderer/modules/permissions/permission_descriptor.idl for valid permission names.
   */
  private final String name;

  /**
   * For "midi" permission, may also specify sysex control.
   */
  @Nullable
  private final Boolean sysex;

  /**
   * For "push" permission, may specify userVisibleOnly.
   * Note that userVisibleOnly = true is the only currently supported type.
   */
  @Nullable
  private final Boolean userVisibleOnly;

  /**
   * For "clipboard" permission, may specify allowWithoutSanitization.
   */
  @Nullable
  private final Boolean allowWithoutSanitization;

  /**
   * For "fullscreen" permission, must specify allowWithoutGesture:true.
   */
  @Nullable
  private final Boolean allowWithoutGesture;

  /**
   * For "camera" permission, may specify panTiltZoom.
   */
  @Nullable
  private final Boolean panTiltZoom;
}
