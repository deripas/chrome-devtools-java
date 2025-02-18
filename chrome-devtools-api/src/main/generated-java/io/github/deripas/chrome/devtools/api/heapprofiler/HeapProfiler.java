package io.github.deripas.chrome.devtools.api.heapprofiler;

import com.fasterxml.jackson.annotation.JsonTypeName;
import io.github.deripas.chrome.devtools.api.Disposable;
import io.github.deripas.chrome.devtools.api.runtime.RemoteObject;
import io.github.deripas.chrome.devtools.api.runtime.RemoteObjectId;
import java.lang.Boolean;
import java.lang.Deprecated;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import java.lang.Void;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Experimental
@Generated
public interface HeapProfiler {
  /**
   * Enables console to refer to the node with given id via &#36;x (see Command Line API for more details
   * &#36;x functions).
   */
  CompletableFuture<Void> addInspectedHeapObject(AddInspectedHeapObjectRequest request);

  CompletableFuture<Void> collectGarbage();

  CompletableFuture<Void> disable();

  CompletableFuture<Void> enable();

  CompletableFuture<GetHeapObjectIdResponse> getHeapObjectId(GetHeapObjectIdRequest request);

  CompletableFuture<GetObjectByHeapObjectIdResponse> getObjectByHeapObjectId(
      GetObjectByHeapObjectIdRequest request);

  CompletableFuture<GetSamplingProfileResponse> getSamplingProfile();

  CompletableFuture<Void> startSampling(StartSamplingRequest request);

  CompletableFuture<Void> startTrackingHeapObjects(StartTrackingHeapObjectsRequest request);

  CompletableFuture<StopSamplingResponse> stopSampling();

  CompletableFuture<Void> stopTrackingHeapObjects(StopTrackingHeapObjectsRequest request);

  CompletableFuture<Void> takeHeapSnapshot(TakeHeapSnapshotRequest request);

  Disposable onAddHeapSnapshotChunk(Consumer<AddHeapSnapshotChunkEvent> listener);

  Disposable onHeapStatsUpdate(Consumer<HeapStatsUpdateEvent> listener);

  Disposable onLastSeenObjectId(Consumer<LastSeenObjectIdEvent> listener);

  Disposable onReportHeapSnapshotProgress(Consumer<ReportHeapSnapshotProgressEvent> listener);

  Disposable onResetProfiles(Consumer<ResetProfilesEvent> listener);

  @Data
  @Builder(
      toBuilder = true
  )
  class AddInspectedHeapObjectRequest {
    /**
     * Heap snapshot object id to be accessible by means of &#36;x command line API.
     */
    private final HeapSnapshotObjectId heapObjectId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetHeapObjectIdRequest {
    /**
     * Identifier of the object to get heap object id for.
     */
    private final RemoteObjectId objectId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetHeapObjectIdResponse {
    /**
     * Id of the heap snapshot object corresponding to the passed remote object id.
     */
    private final HeapSnapshotObjectId heapSnapshotObjectId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetObjectByHeapObjectIdRequest {
    private final HeapSnapshotObjectId objectId;

    /**
     * Symbolic group name that can be used to release multiple objects.
     */
    @Nullable
    private final String objectGroup;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetObjectByHeapObjectIdResponse {
    /**
     * Evaluation result.
     */
    private final RemoteObject result;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetSamplingProfileResponse {
    /**
     * Return the sampling profile being collected.
     */
    private final SamplingHeapProfile profile;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class StartSamplingRequest {
    /**
     * Average sample interval in bytes. Poisson distribution is used for the intervals. The
     * default value is 32768 bytes.
     */
    @Nullable
    private final Double samplingInterval;

    /**
     * By default, the sampling heap profiler reports only objects which are
     * still alive when the profile is returned via getSamplingProfile or
     * stopSampling, which is useful for determining what functions contribute
     * the most to steady-state memory usage. This flag instructs the sampling
     * heap profiler to also include information about objects discarded by
     * major GC, which will show which functions cause large temporary memory
     * usage or long GC pauses.
     */
    @Nullable
    private final Boolean includeObjectsCollectedByMajorGC;

    /**
     * By default, the sampling heap profiler reports only objects which are
     * still alive when the profile is returned via getSamplingProfile or
     * stopSampling, which is useful for determining what functions contribute
     * the most to steady-state memory usage. This flag instructs the sampling
     * heap profiler to also include information about objects discarded by
     * minor GC, which is useful when tuning a latency-sensitive application
     * for minimal GC activity.
     */
    @Nullable
    private final Boolean includeObjectsCollectedByMinorGC;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class StartTrackingHeapObjectsRequest {
    @Nullable
    private final Boolean trackAllocations;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class StopSamplingResponse {
    /**
     * Recorded sampling heap profile.
     */
    private final SamplingHeapProfile profile;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class StopTrackingHeapObjectsRequest {
    /**
     * If true 'reportHeapSnapshotProgress' events will be generated while snapshot is being taken
     * when the tracking is stopped.
     */
    @Nullable
    private final Boolean reportProgress;

    /**
     * Deprecated in favor of `exposeInternals`.
     */
    @Nullable
    @Deprecated
    private final Boolean treatGlobalObjectsAsRoots;

    /**
     * If true, numerical values are included in the snapshot
     */
    @Nullable
    private final Boolean captureNumericValue;

    /**
     * If true, exposes internals of the snapshot.
     */
    @Nullable
    @Experimental
    private final Boolean exposeInternals;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class TakeHeapSnapshotRequest {
    /**
     * If true 'reportHeapSnapshotProgress' events will be generated while snapshot is being taken.
     */
    @Nullable
    private final Boolean reportProgress;

    /**
     * If true, a raw snapshot without artificial roots will be generated.
     * Deprecated in favor of `exposeInternals`.
     */
    @Nullable
    @Deprecated
    private final Boolean treatGlobalObjectsAsRoots;

    /**
     * If true, numerical values are included in the snapshot
     */
    @Nullable
    private final Boolean captureNumericValue;

    /**
     * If true, exposes internals of the snapshot.
     */
    @Nullable
    @Experimental
    private final Boolean exposeInternals;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("addHeapSnapshotChunk")
  class AddHeapSnapshotChunkEvent {
    private final String chunk;
  }

  /**
   * If heap objects tracking has been started then backend may send update for one or more fragments
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("heapStatsUpdate")
  class HeapStatsUpdateEvent {
    /**
     * An array of triplets. Each triplet describes a fragment. The first integer is the fragment
     * index, the second integer is a total count of objects for the fragment, the third integer is
     * a total size of the objects for the fragment.
     */
    private final List<Integer> statsUpdate;
  }

  /**
   * If heap objects tracking has been started then backend regularly sends a current value for last
   * seen object id and corresponding timestamp. If the were changes in the heap since last event
   * then one or more heapStatsUpdate events will be sent before a new lastSeenObjectId event.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("lastSeenObjectId")
  class LastSeenObjectIdEvent {
    private final Integer lastSeenObjectId;

    private final Double timestamp;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("reportHeapSnapshotProgress")
  class ReportHeapSnapshotProgressEvent {
    private final Integer done;

    private final Integer total;

    @Nullable
    private final Boolean finished;
  }

  @JsonTypeName("resetProfiles")
  class ResetProfilesEvent {
  }
}
