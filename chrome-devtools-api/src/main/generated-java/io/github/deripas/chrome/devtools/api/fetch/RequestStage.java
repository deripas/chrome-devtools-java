package io.github.deripas.chrome.devtools.api.fetch;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * Stages of the request to handle. Request will intercept before the request is
 * sent. Response will intercept after the response is received (but before response
 * body is received).
 */
@Generated
public enum RequestStage {
  @JsonProperty("Request")
  REQUEST,

  @JsonProperty("Response")
  RESPONSE
}
