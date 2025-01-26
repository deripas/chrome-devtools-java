package org.deripas.chrome.protocol.api.dom.event;

import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.dom.NodeId;

/**
 * Fired when `Element`'s attribute is modified.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class AttributeModifiedEvent {
  public static final EventId<AttributeModifiedEvent> ID = new EventId<>("DOM.attributeModified", AttributeModifiedEvent.class);

  /**
   * Id of the node that has changed.
   */
  private final NodeId nodeId;

  /**
   * Attribute name.
   */
  private final String name;

  /**
   * Attribute value.
   */
  private final String value;
}
