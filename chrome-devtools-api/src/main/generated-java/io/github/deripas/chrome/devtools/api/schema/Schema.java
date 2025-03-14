package io.github.deripas.chrome.devtools.api.schema;

import io.github.deripas.chrome.devtools.api.Session;
import java.lang.Deprecated;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.RequiredArgsConstructor;

/**
 * This domain is deprecated.
 */
@RequiredArgsConstructor
@Deprecated
@Generated
public class Schema {
  private final Session session;

  /**
   * Returns supported domains.
   */
  public CompletableFuture<GetDomainsResponse> getDomains() {
    return session.send("Schema.getDomains", null, GetDomainsResponse.class);
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetDomainsResponse {
    /**
     * List of supported domains.
     */
    private final List<Domain> domains;
  }
}
