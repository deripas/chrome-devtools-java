package io.github.deripas.chrome.devtools.api.pwa;

import java.lang.String;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * The following types are the replica of
 * https://crsrc.org/c/chrome/browser/web_applications/proto/web_app_os_integration_state.proto;drc=9910d3be894c8f142c977ba1023f30a656bc13fc;l=67
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class FileHandlerAccept {
  /**
   * New name of the mimetype according to
   * https://www.iana.org/assignments/media-types/media-types.xhtml
   */
  private final String mediaType;

  private final List<String> fileExtensions;
}
