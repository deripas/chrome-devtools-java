package org.deripas.chrome.protocol.api.log;

import java.lang.Void;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Provides access to log entries.
 */
@Generated
public interface Log {
  /**
   * Clears the log.
   */
  CompletableFuture<Void> clear();

  /**
   * Disables log domain, prevents further log entries from being reported to the client.
   */
  CompletableFuture<Void> disable();

  /**
   * Enables log domain, sends the entries collected so far to the client by means of the
   * `entryAdded` notification.
   */
  CompletableFuture<Void> enable();

  /**
   * start violation reporting.
   */
  CompletableFuture<Void> startViolationsReport(StartViolationsReportRequest request);

  /**
   * Stop violation reporting.
   */
  CompletableFuture<Void> stopViolationsReport();

  @Data
  @Builder(
      toBuilder = true
  )
  class StartViolationsReportRequest {
    /**
     * Configuration for violations.
     */
    private final List<ViolationSetting> config;
  }
}
