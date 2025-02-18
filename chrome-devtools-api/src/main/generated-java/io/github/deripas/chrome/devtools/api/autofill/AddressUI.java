package io.github.deripas.chrome.devtools.api.autofill;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Defines how an address can be displayed like in chrome://settings/addresses.
 * Address UI is a two dimensional array, each inner array is an "address information line", and when rendered in a UI surface should be displayed as such.
 * The following address UI for instance:
 * [[{name: "GIVE_NAME", value: "Jon"}, {name: "FAMILY_NAME", value: "Doe"}], [{name: "CITY", value: "Munich"}, {name: "ZIP", value: "81456"}]]
 * should allow the receiver to render:
 * Jon Doe
 * Munich 81456
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class AddressUI {
  /**
   * A two dimension array containing the representation of values from an address profile.
   */
  private final List<AddressFields> addressFields;
}
