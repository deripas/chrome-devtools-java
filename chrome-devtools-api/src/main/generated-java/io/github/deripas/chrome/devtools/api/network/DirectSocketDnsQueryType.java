package io.github.deripas.chrome.devtools.api.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

@Experimental
@Generated
public enum DirectSocketDnsQueryType {
  @JsonProperty("ipv4")
  IPV4,

  @JsonProperty("ipv6")
  IPV6
}
