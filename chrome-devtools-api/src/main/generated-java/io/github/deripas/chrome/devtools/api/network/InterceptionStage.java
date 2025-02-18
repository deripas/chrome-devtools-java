package io.github.deripas.chrome.devtools.api.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

/**
 * Stages of the interception to begin intercepting. Request will intercept before the request is
 * sent. Response will intercept after the response is received.
 */
@Experimental
@Generated
public enum InterceptionStage {
  @JsonProperty("Request")
  REQUEST,

  @JsonProperty("HeadersReceived")
  HEADERS_RECEIVED
}
