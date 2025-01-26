package org.deripas.chrome.protocol.api.layertree.event;

import java.util.List;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.layertree.Layer;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class LayerTreeDidChangeEvent {
  public static final EventId<LayerTreeDidChangeEvent> ID = new EventId<>("LayerTree.layerTreeDidChange", LayerTreeDidChangeEvent.class);

  /**
   * Layer tree, absent if not in the compositing mode.
   */
  @Nullable
  private final List<Layer> layers;
}
