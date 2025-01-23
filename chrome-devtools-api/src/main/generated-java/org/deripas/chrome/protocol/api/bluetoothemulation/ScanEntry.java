package org.deripas.chrome.protocol.api.bluetoothemulation;

import java.lang.Integer;
import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Stores the advertisement packet information that is sent by a Bluetooth device.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ScanEntry {
  private final String deviceAddress;

  private final Integer rssi;

  private final ScanRecord scanRecord;
}
