package org.deripas.chrome.protocol.api.autofill;

import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class AddressField {
  /**
   * address field name, for example GIVEN_NAME.
   */
  private final String name;

  /**
   * address field value, for example Jon Doe.
   */
  private final String value;
}
