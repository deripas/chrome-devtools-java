package org.deripas.chrome.protocol.api.accessibility.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.accessibility.AXNode;

/**
 * The loadComplete event mirrors the load complete event sent by the browser to assistive
 * technology when the web page has finished loading.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class LoadCompleteEvent {
  public static final EventId<LoadCompleteEvent> ID = new EventId<>("Accessibility.loadComplete", LoadCompleteEvent.class);

  /**
   * New document root node.
   */
  private final AXNode root;
}
