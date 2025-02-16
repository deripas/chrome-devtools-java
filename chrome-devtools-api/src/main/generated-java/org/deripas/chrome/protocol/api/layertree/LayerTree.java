package org.deripas.chrome.protocol.api.layertree;

import com.fasterxml.jackson.annotation.JsonTypeName;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import java.lang.Void;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.Disposable;
import org.deripas.chrome.protocol.api.dom.Rect;

@Experimental
@Generated
public interface LayerTree {
  /**
   * Provides the reasons why the given layer was composited.
   */
  CompletableFuture<CompositingReasonsResponse> compositingReasons(
      CompositingReasonsRequest request);

  /**
   * Disables compositing tree inspection.
   */
  CompletableFuture<Void> disable();

  /**
   * Enables compositing tree inspection.
   */
  CompletableFuture<Void> enable();

  /**
   * Returns the snapshot identifier.
   */
  CompletableFuture<LoadSnapshotResponse> loadSnapshot(LoadSnapshotRequest request);

  /**
   * Returns the layer snapshot identifier.
   */
  CompletableFuture<MakeSnapshotResponse> makeSnapshot(MakeSnapshotRequest request);

  CompletableFuture<ProfileSnapshotResponse> profileSnapshot(ProfileSnapshotRequest request);

  /**
   * Releases layer snapshot captured by the back-end.
   */
  CompletableFuture<Void> releaseSnapshot(ReleaseSnapshotRequest request);

  /**
   * Replays the layer snapshot and returns the resulting bitmap.
   */
  CompletableFuture<ReplaySnapshotResponse> replaySnapshot(ReplaySnapshotRequest request);

  /**
   * Replays the layer snapshot and returns canvas log.
   */
  CompletableFuture<SnapshotCommandLogResponse> snapshotCommandLog(
      SnapshotCommandLogRequest request);

  Disposable onLayerPainted(Consumer<LayerPaintedEvent> listener);

  Disposable onLayerTreeDidChange(Consumer<LayerTreeDidChangeEvent> listener);

  @Data
  @Builder(
      toBuilder = true
  )
  class CompositingReasonsRequest {
    /**
     * The id of the layer for which we want to get the reasons it was composited.
     */
    private final LayerId layerId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class CompositingReasonsResponse {
    /**
     * A list of strings specifying reasons for the given layer to become composited.
     */
    private final List<String> compositingReasons;

    /**
     * A list of strings specifying reason IDs for the given layer to become composited.
     */
    private final List<String> compositingReasonIds;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class LoadSnapshotRequest {
    /**
     * An array of tiles composing the snapshot.
     */
    private final List<PictureTile> tiles;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class LoadSnapshotResponse {
    /**
     * The id of the snapshot.
     */
    private final SnapshotId snapshotId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class MakeSnapshotRequest {
    /**
     * The id of the layer.
     */
    private final LayerId layerId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class MakeSnapshotResponse {
    /**
     * The id of the layer snapshot.
     */
    private final SnapshotId snapshotId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class ProfileSnapshotRequest {
    /**
     * The id of the layer snapshot.
     */
    private final SnapshotId snapshotId;

    /**
     * The maximum number of times to replay the snapshot (1, if not specified).
     */
    @Nullable
    private final Integer minRepeatCount;

    /**
     * The minimum duration (in seconds) to replay the snapshot.
     */
    @Nullable
    private final Double minDuration;

    /**
     * The clip rectangle to apply when replaying the snapshot.
     */
    @Nullable
    private final Rect clipRect;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class ProfileSnapshotResponse {
    /**
     * The array of paint profiles, one per run.
     */
    private final List<PaintProfile> timings;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class ReleaseSnapshotRequest {
    /**
     * The id of the layer snapshot.
     */
    private final SnapshotId snapshotId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class ReplaySnapshotRequest {
    /**
     * The id of the layer snapshot.
     */
    private final SnapshotId snapshotId;

    /**
     * The first step to replay from (replay from the very start if not specified).
     */
    @Nullable
    private final Integer fromStep;

    /**
     * The last step to replay to (replay till the end if not specified).
     */
    @Nullable
    private final Integer toStep;

    /**
     * The scale to apply while replaying (defaults to 1).
     */
    @Nullable
    private final Double scale;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class ReplaySnapshotResponse {
    /**
     * A data: URL for resulting image.
     */
    private final String dataURL;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SnapshotCommandLogRequest {
    /**
     * The id of the layer snapshot.
     */
    private final SnapshotId snapshotId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SnapshotCommandLogResponse {
    /**
     * The array of canvas function calls.
     */
    private final List<Map> commandLog;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("layerPainted")
  class LayerPaintedEvent {
    /**
     * The id of the painted layer.
     */
    private final LayerId layerId;

    /**
     * Clip rectangle.
     */
    private final Rect clip;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("layerTreeDidChange")
  class LayerTreeDidChangeEvent {
    /**
     * Layer tree, absent if not in the compositing mode.
     */
    @Nullable
    private final List<Layer> layers;
  }
}
