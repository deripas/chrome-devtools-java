package org.deripas.chrome.protocol.api.dom.event;

import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.dom.NodeId;

/**
 * Fired when `Element`'s attribute is removed.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class AttributeRemovedEvent {
  public static final EventId<AttributeRemovedEvent> ID = new EventId<>("DOM.attributeRemoved", AttributeRemovedEvent.class);

  /**
   * Id of the node that has changed.
   */
  private final NodeId nodeId;

  /**
   * A ttribute name.
   */
  private final String name;
}
