package io.github.deripas.chrome.devtools.api.bluetoothemulation;

import java.lang.Integer;
import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Stores the manufacturer data
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ManufacturerData {
  /**
   * Company identifier
   * https://bitbucket.org/bluetooth-SIG/public/src/main/assigned_numbers/company_identifiers/company_identifiers.yaml
   * https://usb.org/developers
   */
  private final Integer key;

  /**
   * Manufacturer-specific data (Encoded as a base64 string when passed over JSON)
   */
  private final String data;
}
