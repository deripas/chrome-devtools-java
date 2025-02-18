package io.github.deripas.chrome.devtools.api.systeminfo;

import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * The SystemInfo domain defines methods and events for querying low-level system information.
 */
@Experimental
@Generated
public interface SystemInfo {
  /**
   * Returns information about the system.
   */
  CompletableFuture<GetInfoResponse> getInfo();

  /**
   * Returns information about the feature state.
   */
  CompletableFuture<GetFeatureStateResponse> getFeatureState(GetFeatureStateRequest request);

  /**
   * Returns information about all running processes.
   */
  CompletableFuture<GetProcessInfoResponse> getProcessInfo();

  @Data
  @Builder(
      toBuilder = true
  )
  class GetInfoResponse {
    /**
     * Information about the GPUs on the system.
     */
    private final GPUInfo gpu;

    /**
     * A platform-dependent description of the model of the machine. On Mac OS, this is, for
     * example, 'MacBookPro'. Will be the empty string if not supported.
     */
    private final String modelName;

    /**
     * A platform-dependent description of the version of the machine. On Mac OS, this is, for
     * example, '10.1'. Will be the empty string if not supported.
     */
    private final String modelVersion;

    /**
     * The command line string used to launch the browser. Will be the empty string if not
     * supported.
     */
    private final String commandLine;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetFeatureStateRequest {
    private final String featureState;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetFeatureStateResponse {
    private final Boolean featureEnabled;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetProcessInfoResponse {
    /**
     * An array of process info blocks.
     */
    private final List<ProcessInfo> processInfo;
  }
}
