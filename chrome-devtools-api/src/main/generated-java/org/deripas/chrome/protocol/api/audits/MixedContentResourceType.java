package org.deripas.chrome.protocol.api.audits;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

@Generated
public enum MixedContentResourceType {
  @JsonProperty("AttributionSrc")
  ATTRIBUTION_SRC,

  @JsonProperty("Audio")
  AUDIO,

  @JsonProperty("Beacon")
  BEACON,

  @JsonProperty("CSPReport")
  C_S_P_REPORT,

  @JsonProperty("Download")
  DOWNLOAD,

  @JsonProperty("EventSource")
  EVENT_SOURCE,

  @JsonProperty("Favicon")
  FAVICON,

  @JsonProperty("Font")
  FONT,

  @JsonProperty("Form")
  FORM,

  @JsonProperty("Frame")
  FRAME,

  @JsonProperty("Image")
  IMAGE,

  @JsonProperty("Import")
  IMPORT,

  @JsonProperty("JSON")
  J_S_O_N,

  @JsonProperty("Manifest")
  MANIFEST,

  @JsonProperty("Ping")
  PING,

  @JsonProperty("PluginData")
  PLUGIN_DATA,

  @JsonProperty("PluginResource")
  PLUGIN_RESOURCE,

  @JsonProperty("Prefetch")
  PREFETCH,

  @JsonProperty("Resource")
  RESOURCE,

  @JsonProperty("Script")
  SCRIPT,

  @JsonProperty("ServiceWorker")
  SERVICE_WORKER,

  @JsonProperty("SharedWorker")
  SHARED_WORKER,

  @JsonProperty("SpeculationRules")
  SPECULATION_RULES,

  @JsonProperty("Stylesheet")
  STYLESHEET,

  @JsonProperty("Track")
  TRACK,

  @JsonProperty("Video")
  VIDEO,

  @JsonProperty("Worker")
  WORKER,

  @JsonProperty("XMLHttpRequest")
  X_M_L_HTTP_REQUEST,

  @JsonProperty("XSLT")
  X_S_L_T
}
