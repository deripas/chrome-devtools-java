package org.deripas.chrome.protocol.api.storage;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * Enum of shared storage access types.
 */
@Generated
public enum SharedStorageAccessType {
  @JsonProperty("documentAddModule")
  DOCUMENT_ADD_MODULE,

  @JsonProperty("documentSelectURL")
  DOCUMENT_SELECT_U_R_L,

  @JsonProperty("documentRun")
  DOCUMENT_RUN,

  @JsonProperty("documentSet")
  DOCUMENT_SET,

  @JsonProperty("documentAppend")
  DOCUMENT_APPEND,

  @JsonProperty("documentDelete")
  DOCUMENT_DELETE,

  @JsonProperty("documentClear")
  DOCUMENT_CLEAR,

  @JsonProperty("documentGet")
  DOCUMENT_GET,

  @JsonProperty("workletSet")
  WORKLET_SET,

  @JsonProperty("workletAppend")
  WORKLET_APPEND,

  @JsonProperty("workletDelete")
  WORKLET_DELETE,

  @JsonProperty("workletClear")
  WORKLET_CLEAR,

  @JsonProperty("workletGet")
  WORKLET_GET,

  @JsonProperty("workletKeys")
  WORKLET_KEYS,

  @JsonProperty("workletEntries")
  WORKLET_ENTRIES,

  @JsonProperty("workletLength")
  WORKLET_LENGTH,

  @JsonProperty("workletRemainingBudget")
  WORKLET_REMAINING_BUDGET,

  @JsonProperty("headerSet")
  HEADER_SET,

  @JsonProperty("headerAppend")
  HEADER_APPEND,

  @JsonProperty("headerDelete")
  HEADER_DELETE,

  @JsonProperty("headerClear")
  HEADER_CLEAR
}
