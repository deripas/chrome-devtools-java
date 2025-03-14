package io.github.deripas.chrome.devtools.api.systeminfo;

import io.github.deripas.chrome.devtools.api.Session;
import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.RequiredArgsConstructor;

/**
 * The SystemInfo domain defines methods and events for querying low-level system information.
 */
@RequiredArgsConstructor
@Experimental
@Generated
public class SystemInfo {
  private final Session session;

  /**
   * Returns information about the system.
   */
  public CompletableFuture<GetInfoResponse> getInfo() {
    return session.send("SystemInfo.getInfo", null, GetInfoResponse.class);
  }

  /**
   * Returns information about the feature state.
   */
  public CompletableFuture<GetFeatureStateResponse> getFeatureState(
      GetFeatureStateRequest request) {
    return session.send("SystemInfo.getFeatureState", request, GetFeatureStateResponse.class);
  }

  /**
   * Returns information about all running processes.
   */
  public CompletableFuture<GetProcessInfoResponse> getProcessInfo() {
    return session.send("SystemInfo.getProcessInfo", null, GetProcessInfoResponse.class);
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetInfoResponse {
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
  public static class GetFeatureStateRequest {
    private final String featureState;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetFeatureStateResponse {
    private final Boolean featureEnabled;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetProcessInfoResponse {
    /**
     * An array of process info blocks.
     */
    private final List<ProcessInfo> processInfo;
  }
}
