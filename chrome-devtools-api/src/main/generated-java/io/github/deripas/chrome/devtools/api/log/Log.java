package io.github.deripas.chrome.devtools.api.log;

import io.github.deripas.chrome.devtools.api.Disposable;
import io.github.deripas.chrome.devtools.api.Session;
import java.lang.Void;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.RequiredArgsConstructor;

/**
 * Provides access to log entries.
 */
@RequiredArgsConstructor
@Generated
public class Log {
  private final Session session;

  /**
   * Clears the log.
   */
  public CompletableFuture<Void> clear() {
    return session.send("Log.clear", null, Void.class);
  }

  /**
   * Disables log domain, prevents further log entries from being reported to the client.
   */
  public CompletableFuture<Void> disable() {
    return session.send("Log.disable", null, Void.class);
  }

  /**
   * Enables log domain, sends the entries collected so far to the client by means of the
   * `entryAdded` notification.
   */
  public CompletableFuture<Void> enable() {
    return session.send("Log.enable", null, Void.class);
  }

  /**
   * start violation reporting.
   */
  public CompletableFuture<Void> startViolationsReport(StartViolationsReportRequest request) {
    return session.send("Log.startViolationsReport", request, Void.class);
  }

  /**
   * Stop violation reporting.
   */
  public CompletableFuture<Void> stopViolationsReport() {
    return session.send("Log.stopViolationsReport", null, Void.class);
  }

  public Disposable onEntryAdded(Consumer<EntryAddedEvent> listener) {
    return session.subscribe("Log.entryAdded", listener, EntryAddedEvent.class);
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class StartViolationsReportRequest {
    /**
     * Configuration for violations.
     */
    private final List<ViolationSetting> config;
  }

  /**
   * Issued when new message was logged.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class EntryAddedEvent {
    /**
     * The entry.
     */
    private final LogEntry entry;
  }
}
