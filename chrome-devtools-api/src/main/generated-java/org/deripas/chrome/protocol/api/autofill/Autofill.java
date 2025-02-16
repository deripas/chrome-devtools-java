package org.deripas.chrome.protocol.api.autofill;

import com.fasterxml.jackson.annotation.JsonTypeName;
import java.lang.Void;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.Disposable;
import org.deripas.chrome.protocol.api.dom.BackendNodeId;
import org.deripas.chrome.protocol.api.page.FrameId;

/**
 * Defines commands and events for Autofill.
 */
@Experimental
@Generated
public interface Autofill {
  /**
   * Trigger autofill on a form identified by the fieldId.
   * If the field and related form cannot be autofilled, returns an error.
   */
  CompletableFuture<Void> trigger(TriggerRequest request);

  /**
   * Set addresses so that developers can verify their forms implementation.
   */
  CompletableFuture<Void> setAddresses(SetAddressesRequest request);

  /**
   * Disables autofill domain notifications.
   */
  CompletableFuture<Void> disable();

  /**
   * Enables autofill domain notifications.
   */
  CompletableFuture<Void> enable();

  Disposable onAddressFormFilled(Consumer<AddressFormFilledEvent> listener);

  @Data
  @Builder(
      toBuilder = true
  )
  class TriggerRequest {
    /**
     * Identifies a field that serves as an anchor for autofill.
     */
    private final BackendNodeId fieldId;

    /**
     * Identifies the frame that field belongs to.
     */
    @Nullable
    private final FrameId frameId;

    /**
     * Credit card information to fill out the form. Credit card data is not saved.
     */
    private final CreditCard card;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetAddressesRequest {
    private final List<Address> addresses;
  }

  /**
   * Emitted when an address form is filled.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("addressFormFilled")
  class AddressFormFilledEvent {
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
}
