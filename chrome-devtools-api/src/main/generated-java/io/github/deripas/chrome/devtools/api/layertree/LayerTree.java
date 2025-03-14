package io.github.deripas.chrome.devtools.api.layertree;

import io.github.deripas.chrome.devtools.api.Disposable;
import io.github.deripas.chrome.devtools.api.Session;
import io.github.deripas.chrome.devtools.api.dom.Rect;
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
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Experimental
@Generated
public class LayerTree {
  private final Session session;

  /**
   * Provides the reasons why the given layer was composited.
   */
  public CompletableFuture<CompositingReasonsResponse> compositingReasons(
      CompositingReasonsRequest request) {
    return session.send("LayerTree.compositingReasons", request, CompositingReasonsResponse.class);
  }

  /**
   * Disables compositing tree inspection.
   */
  public CompletableFuture<Void> disable() {
    return session.send("LayerTree.disable", null, Void.class);
  }

  /**
   * Enables compositing tree inspection.
   */
  public CompletableFuture<Void> enable() {
    return session.send("LayerTree.enable", null, Void.class);
  }

  /**
   * Returns the snapshot identifier.
   */
  public CompletableFuture<LoadSnapshotResponse> loadSnapshot(LoadSnapshotRequest request) {
    return session.send("LayerTree.loadSnapshot", request, LoadSnapshotResponse.class);
  }

  /**
   * Returns the layer snapshot identifier.
   */
  public CompletableFuture<MakeSnapshotResponse> makeSnapshot(MakeSnapshotRequest request) {
    return session.send("LayerTree.makeSnapshot", request, MakeSnapshotResponse.class);
  }

  public CompletableFuture<ProfileSnapshotResponse> profileSnapshot(
      ProfileSnapshotRequest request) {
    return session.send("LayerTree.profileSnapshot", request, ProfileSnapshotResponse.class);
  }

  /**
   * Releases layer snapshot captured by the back-end.
   */
  public CompletableFuture<Void> releaseSnapshot(ReleaseSnapshotRequest request) {
    return session.send("LayerTree.releaseSnapshot", request, Void.class);
  }

  /**
   * Replays the layer snapshot and returns the resulting bitmap.
   */
  public CompletableFuture<ReplaySnapshotResponse> replaySnapshot(ReplaySnapshotRequest request) {
    return session.send("LayerTree.replaySnapshot", request, ReplaySnapshotResponse.class);
  }

  /**
   * Replays the layer snapshot and returns canvas log.
   */
  public CompletableFuture<SnapshotCommandLogResponse> snapshotCommandLog(
      SnapshotCommandLogRequest request) {
    return session.send("LayerTree.snapshotCommandLog", request, SnapshotCommandLogResponse.class);
  }

  public Disposable onLayerPainted(Consumer<LayerPaintedEvent> listener) {
    return session.subscribe("LayerTree.layerPainted", listener, LayerPaintedEvent.class);
  }

  public Disposable onLayerTreeDidChange(Consumer<LayerTreeDidChangeEvent> listener) {
    return session.subscribe("LayerTree.layerTreeDidChange", listener, LayerTreeDidChangeEvent.class);
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class CompositingReasonsRequest {
    /**
     * The id of the layer for which we want to get the reasons it was composited.
     */
    private final LayerId layerId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class CompositingReasonsResponse {
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
  public static class LoadSnapshotRequest {
    /**
     * An array of tiles composing the snapshot.
     */
    private final List<PictureTile> tiles;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class LoadSnapshotResponse {
    /**
     * The id of the snapshot.
     */
    private final SnapshotId snapshotId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class MakeSnapshotRequest {
    /**
     * The id of the layer.
     */
    private final LayerId layerId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class MakeSnapshotResponse {
    /**
     * The id of the layer snapshot.
     */
    private final SnapshotId snapshotId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class ProfileSnapshotRequest {
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
  public static class ProfileSnapshotResponse {
    /**
     * The array of paint profiles, one per run.
     */
    private final List<PaintProfile> timings;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class ReleaseSnapshotRequest {
    /**
     * The id of the layer snapshot.
     */
    private final SnapshotId snapshotId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class ReplaySnapshotRequest {
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
  public static class ReplaySnapshotResponse {
    /**
     * A data: URL for resulting image.
     */
    private final String dataURL;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SnapshotCommandLogRequest {
    /**
     * The id of the layer snapshot.
     */
    private final SnapshotId snapshotId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SnapshotCommandLogResponse {
    /**
     * The array of canvas function calls.
     */
    private final List<Map> commandLog;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class LayerPaintedEvent {
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
  public static class LayerTreeDidChangeEvent {
    /**
     * Layer tree, absent if not in the compositing mode.
     */
    @Nullable
    private final List<Layer> layers;
  }
}
