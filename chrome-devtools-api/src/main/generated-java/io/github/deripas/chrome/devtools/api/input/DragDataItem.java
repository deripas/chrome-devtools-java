package io.github.deripas.chrome.devtools.api.input;

import java.lang.String;
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
public class DragDataItem {
  /**
   * Mime type of the dragged data.
   */
  private final String mimeType;

  /**
   * Depending of the value of `mimeType`, it contains the dragged link,
   * text, HTML markup or any other data.
   */
  private final String data;

  /**
   * Title associated with a link. Only valid when `mimeType` == "text/uri-list".
   */
  @Nullable
  private final String title;

  /**
   * Stores the base URL for the contained markup. Only valid when `mimeType`
   * == "text/html".
   */
  @Nullable
  private final String baseURL;
}
