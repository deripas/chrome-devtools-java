package org.deripas.chrome.protocol.api.cachestorage;

import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Data entry.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class DataEntry {
  /**
   * Request URL.
   */
  private final String requestURL;

  /**
   * Request method.
   */
  private final String requestMethod;

  /**
   * Request headers
   */
  private final List<Header> requestHeaders;

  /**
   * Number of seconds since epoch.
   */
  private final Long responseTime;

  /**
   * HTTP response status code.
   */
  private final Integer responseStatus;

  /**
   * HTTP response status text.
   */
  private final String responseStatusText;

  /**
   * HTTP response type
   */
  private final CachedResponseType responseType;

  /**
   * Response headers
   */
  private final List<Header> responseHeaders;
}
