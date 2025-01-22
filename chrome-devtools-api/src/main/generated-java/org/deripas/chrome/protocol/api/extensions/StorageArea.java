package org.deripas.chrome.protocol.api.extensions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * Storage areas.
 */
@Generated
public enum StorageArea {
  @JsonProperty("session")
  SESSION,

  @JsonProperty("local")
  LOCAL,

  @JsonProperty("sync")
  SYNC,

  @JsonProperty("managed")
  MANAGED
}
