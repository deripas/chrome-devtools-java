package org.deripas.chrome.protocol.api.webauthn;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

@Generated
public enum AuthenticatorTransport {
  @JsonProperty("usb")
  USB,

  @JsonProperty("nfc")
  NFC,

  @JsonProperty("ble")
  BLE,

  @JsonProperty("cable")
  CABLE,

  @JsonProperty("internal")
  INTERNAL
}
