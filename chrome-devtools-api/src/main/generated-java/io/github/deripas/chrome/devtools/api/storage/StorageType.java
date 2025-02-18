package io.github.deripas.chrome.devtools.api.storage;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * Enum of possible storage types.
 */
@Generated
public enum StorageType {
  @JsonProperty("cookies")
  COOKIES,

  @JsonProperty("file_systems")
  FILE_SYSTEMS,

  @JsonProperty("indexeddb")
  INDEXEDDB,

  @JsonProperty("local_storage")
  LOCAL_STORAGE,

  @JsonProperty("shader_cache")
  SHADER_CACHE,

  @JsonProperty("websql")
  WEBSQL,

  @JsonProperty("service_workers")
  SERVICE_WORKERS,

  @JsonProperty("cache_storage")
  CACHE_STORAGE,

  @JsonProperty("interest_groups")
  INTEREST_GROUPS,

  @JsonProperty("shared_storage")
  SHARED_STORAGE,

  @JsonProperty("storage_buckets")
  STORAGE_BUCKETS,

  @JsonProperty("all")
  ALL,

  @JsonProperty("other")
  OTHER
}
