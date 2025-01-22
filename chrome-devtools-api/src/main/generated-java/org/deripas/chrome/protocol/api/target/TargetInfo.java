package org.deripas.chrome.protocol.api.target;

import java.lang.Boolean;
import java.lang.String;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.browser.BrowserContextID;
import org.deripas.chrome.protocol.api.page.FrameId;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class TargetInfo {
  private final TargetID targetId;

  /**
   * List of types: https://source.chromium.org/chromium/chromium/src/+/main:content/browser/devtools/devtools_agent_host_impl.cc?ss=chromium&q=f:devtools%20-f:out%20%22::kTypeTab%5B%5D%22
   */
  private final String type;

  private final String title;

  private final String url;

  /**
   * Whether the target has an attached client.
   */
  private final Boolean attached;

  /**
   * Opener target Id
   */
  @Nullable
  private final TargetID openerId;

  /**
   * Whether the target has access to the originating window.
   */
  @Experimental
  private final Boolean canAccessOpener;

  /**
   * Frame id of originating window (is only set if target has an opener).
   */
  @Nullable
  @Experimental
  private final FrameId openerFrameId;

  @Nullable
  @Experimental
  private final BrowserContextID browserContextId;

  /**
   * Provides additional details for specific target types. For example, for
   * the type of "page", this may be set to "prerender".
   */
  @Nullable
  @Experimental
  private final String subtype;
}
