package org.deripas.chrome.protocol.api.page;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

@Experimental
@Generated
public enum ClientNavigationReason {
  @JsonProperty("anchorClick")
  ANCHOR_CLICK,

  @JsonProperty("formSubmissionGet")
  FORM_SUBMISSION_GET,

  @JsonProperty("formSubmissionPost")
  FORM_SUBMISSION_POST,

  @JsonProperty("httpHeaderRefresh")
  HTTP_HEADER_REFRESH,

  @JsonProperty("initialFrameNavigation")
  INITIAL_FRAME_NAVIGATION,

  @JsonProperty("metaTagRefresh")
  META_TAG_REFRESH,

  @JsonProperty("other")
  OTHER,

  @JsonProperty("pageBlockInterstitial")
  PAGE_BLOCK_INTERSTITIAL,

  @JsonProperty("reload")
  RELOAD,

  @JsonProperty("scriptInitiated")
  SCRIPT_INITIATED
}
