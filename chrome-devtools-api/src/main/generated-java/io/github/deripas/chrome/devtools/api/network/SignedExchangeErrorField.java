package io.github.deripas.chrome.devtools.api.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

/**
 * Field type for a signed exchange related error.
 */
@Experimental
@Generated
public enum SignedExchangeErrorField {
  @JsonProperty("signatureSig")
  SIGNATURE_SIG,

  @JsonProperty("signatureIntegrity")
  SIGNATURE_INTEGRITY,

  @JsonProperty("signatureCertUrl")
  SIGNATURE_CERT_URL,

  @JsonProperty("signatureCertSha256")
  SIGNATURE_CERT_SHA256,

  @JsonProperty("signatureValidityUrl")
  SIGNATURE_VALIDITY_URL,

  @JsonProperty("signatureTimestamps")
  SIGNATURE_TIMESTAMPS
}
