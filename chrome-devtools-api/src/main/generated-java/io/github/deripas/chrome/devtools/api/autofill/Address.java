package io.github.deripas.chrome.devtools.api.autofill;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class Address {
  /**
   * fields and values defining an address.
   */
  private final List<AddressField> fields;
}
