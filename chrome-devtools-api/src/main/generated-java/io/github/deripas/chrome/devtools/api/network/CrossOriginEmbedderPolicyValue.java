package io.github.deripas.chrome.devtools.api.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

@Experimental
@Generated
public enum CrossOriginEmbedderPolicyValue {
  @JsonProperty("None")
  NONE,

  @JsonProperty("Credentialless")
  CREDENTIALLESS,

  @JsonProperty("RequireCorp")
  REQUIRE_CORP
}
