package org.deripas.chrome.protocol.api.heapprofiler;

import java.lang.Boolean;
import java.lang.Deprecated;
import java.lang.Long;
import java.lang.String;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.runtime.RemoteObject;
import org.deripas.chrome.protocol.api.runtime.RemoteObjectId;

@Experimental
@Generated
public interface HeapProfiler {
  /**
   * Enables console to refer to the node with given id via &#36;x (see Command Line API for more details
   * &#36;x functions).
   */
  void addInspectedHeapObject(AddInspectedHeapObjectRequest request);

  void collectGarbage();

  void disable();

  void enable();

  CompletableFuture<GetHeapObjectIdResponse> getHeapObjectId(GetHeapObjectIdRequest request);

  CompletableFuture<GetObjectByHeapObjectIdResponse> getObjectByHeapObjectId(
      GetObjectByHeapObjectIdRequest request);

  CompletableFuture<GetSamplingProfileResponse> getSamplingProfile();

  void startSampling(StartSamplingRequest request);

  void startTrackingHeapObjects(StartTrackingHeapObjectsRequest request);

  CompletableFuture<StopSamplingResponse> stopSampling();

  void stopTrackingHeapObjects(StopTrackingHeapObjectsRequest request);

  void takeHeapSnapshot(TakeHeapSnapshotRequest request);

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
    private final Long samplingInterval;

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
}
