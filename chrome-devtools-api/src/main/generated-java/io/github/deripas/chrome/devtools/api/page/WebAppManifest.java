package io.github.deripas.chrome.devtools.api.page;

import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class WebAppManifest {
  @Nullable
  private final String backgroundColor;

  /**
   * The extra description provided by the manifest.
   */
  @Nullable
  private final String description;

  @Nullable
  private final String dir;

  @Nullable
  private final String display;

  /**
   * The overrided display mode controlled by the user.
   */
  @Nullable
  private final List<String> displayOverrides;

  /**
   * The handlers to open files.
   */
  @Nullable
  private final List<FileHandler> fileHandlers;

  @Nullable
  private final List<ImageResource> icons;

  @Nullable
  private final String id;

  @Nullable
  private final String lang;

  /**
   * TODO(crbug.com/1231886): This field is non-standard and part of a Chrome
   * experiment. See:
   * https://github.com/WICG/web-app-launch/blob/main/launch_handler.md
   */
  @Nullable
  private final LaunchHandler launchHandler;

  @Nullable
  private final String name;

  @Nullable
  private final String orientation;

  @Nullable
  private final Boolean preferRelatedApplications;

  /**
   * The handlers to open protocols.
   */
  @Nullable
  private final List<ProtocolHandler> protocolHandlers;

  @Nullable
  private final List<RelatedApplication> relatedApplications;

  @Nullable
  private final String scope;

  /**
   * Non-standard, see
   * https://github.com/WICG/manifest-incubations/blob/gh-pages/scope_extensions-explainer.md
   */
  @Nullable
  private final List<ScopeExtension> scopeExtensions;

  /**
   * The screenshots used by chromium.
   */
  @Nullable
  private final List<Screenshot> screenshots;

  @Nullable
  private final ShareTarget shareTarget;

  @Nullable
  private final String shortName;

  @Nullable
  private final List<Shortcut> shortcuts;

  @Nullable
  private final String startUrl;

  @Nullable
  private final String themeColor;
}
