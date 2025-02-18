package io.github.deripas.chrome.devtools.api.accessibility;

import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import io.github.deripas.chrome.devtools.api.dom.BackendNodeId;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class AXRelatedNode {
  /**
   * The BackendNodeId of the related DOM node.
   */
  private final BackendNodeId backendDOMNodeId;

  /**
   * The IDRef value provided, if any.
   */
  @Nullable
  private final String idref;

  /**
   * The text alternative of this node in the current context.
   */
  @Nullable
  private final String text;
}
