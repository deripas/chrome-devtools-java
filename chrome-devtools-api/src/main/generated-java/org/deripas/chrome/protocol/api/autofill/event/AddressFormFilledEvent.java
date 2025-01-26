package org.deripas.chrome.protocol.api.autofill.event;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.autofill.AddressUI;
import org.deripas.chrome.protocol.api.autofill.FilledField;

/**
 * Emitted when an address form is filled.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class AddressFormFilledEvent {
  public static final EventId<AddressFormFilledEvent> ID = new EventId<>("Autofill.addressFormFilled", AddressFormFilledEvent.class);

  /**
   * Information about the fields that were filled
   */
  private final List<FilledField> filledFields;

  /**
   * An UI representation of the address used to fill the form.
   * Consists of a 2D array where each child represents an address/profile line.
   */
  private final AddressUI addressUi;
}
