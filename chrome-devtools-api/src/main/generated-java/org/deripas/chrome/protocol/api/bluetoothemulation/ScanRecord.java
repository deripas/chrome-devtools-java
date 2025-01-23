package org.deripas.chrome.protocol.api.bluetoothemulation;

import java.lang.Integer;
import java.lang.String;
import java.util.List;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Stores the byte data of the advertisement packet sent by a Bluetooth device.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ScanRecord {
  @Nullable
  private final String name;

  @Nullable
  private final List<String> uuids;

  /**
   * Stores the external appearance description of the device.
   */
  @Nullable
  private final Integer appearance;

  /**
   * Stores the transmission power of a broadcasting device.
   */
  @Nullable
  private final Integer txPower;

  /**
   * Key is the company identifier and the value is an array of bytes of
   * manufacturer specific data.
   */
  @Nullable
  private final List<ManufacturerData> manufacturerData;
}
