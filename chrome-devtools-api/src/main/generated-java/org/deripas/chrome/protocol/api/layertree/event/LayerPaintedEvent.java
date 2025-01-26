package org.deripas.chrome.protocol.api.layertree.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.dom.Rect;
import org.deripas.chrome.protocol.api.layertree.LayerId;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class LayerPaintedEvent {
  public static final EventId<LayerPaintedEvent> ID = new EventId<>("LayerTree.layerPainted", LayerPaintedEvent.class);

  /**
   * The id of the painted layer.
   */
  private final LayerId layerId;

  /**
   * Clip rectangle.
   */
  private final Rect clip;
}
