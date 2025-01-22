package org.deripas.chrome.protocol.api.log;

import java.util.List;
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
  void clear();

  /**
   * Disables log domain, prevents further log entries from being reported to the client.
   */
  void disable();

  /**
   * Enables log domain, sends the entries collected so far to the client by means of the
   * `entryAdded` notification.
   */
  void enable();

  /**
   * start violation reporting.
   */
  void startViolationsReport(StartViolationsReportRequest request);

  /**
   * Stop violation reporting.
   */
  void stopViolationsReport();

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
