package io.github.deripas.chrome.devtools.api.storage;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

@Generated
public enum StorageBucketsDurability {
  @JsonProperty("relaxed")
  RELAXED,

  @JsonProperty("strict")
  STRICT
}
