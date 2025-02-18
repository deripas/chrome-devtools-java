package io.github.deripas.chrome.devtools.api.autofill;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * A list of address fields.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class AddressFields {
  private final List<AddressField> fields;
}
