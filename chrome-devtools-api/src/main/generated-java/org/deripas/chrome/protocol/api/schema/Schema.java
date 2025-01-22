package org.deripas.chrome.protocol.api.schema;

import java.lang.Deprecated;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * This domain is deprecated.
 */
@Deprecated
@Generated
public interface Schema {
  /**
   * Returns supported domains.
   */
  CompletableFuture<GetDomainsResponse> getDomains();

  @Data
  @Builder(
      toBuilder = true
  )
  class GetDomainsResponse {
    /**
     * List of supported domains.
     */
    private final List<Domain> domains;
  }
}
