package org.deripas.chrome.protocol.api.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

/**
 * The reason why Chrome uses a specific transport protocol for HTTP semantics.
 */
@Experimental
@Generated
public enum AlternateProtocolUsage {
  @JsonProperty("alternativeJobWonWithoutRace")
  ALTERNATIVE_JOB_WON_WITHOUT_RACE,

  @JsonProperty("alternativeJobWonRace")
  ALTERNATIVE_JOB_WON_RACE,

  @JsonProperty("mainJobWonRace")
  MAIN_JOB_WON_RACE,

  @JsonProperty("mappingMissing")
  MAPPING_MISSING,

  @JsonProperty("broken")
  BROKEN,

  @JsonProperty("dnsAlpnH3JobWonWithoutRace")
  DNS_ALPN_H3_JOB_WON_WITHOUT_RACE,

  @JsonProperty("dnsAlpnH3JobWonRace")
  DNS_ALPN_H3_JOB_WON_RACE,

  @JsonProperty("unspecifiedReason")
  UNSPECIFIED_REASON
}
