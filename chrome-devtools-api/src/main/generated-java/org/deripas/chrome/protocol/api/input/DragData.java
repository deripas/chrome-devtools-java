package org.deripas.chrome.protocol.api.input;

import java.lang.Integer;
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
public class DragData {
  private final List<DragDataItem> items;

  /**
   * List of filenames that should be included when dropping
   */
  @Nullable
  private final List<String> files;

  /**
   * Bit field representing allowed drag operations. Copy = 1, Link = 2, Move = 16
   */
  private final Integer dragOperationsMask;
}
