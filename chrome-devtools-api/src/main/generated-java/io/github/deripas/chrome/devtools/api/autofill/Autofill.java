package io.github.deripas.chrome.devtools.api.autofill;

import io.github.deripas.chrome.devtools.api.Disposable;
import io.github.deripas.chrome.devtools.api.Session;
import io.github.deripas.chrome.devtools.api.dom.BackendNodeId;
import io.github.deripas.chrome.devtools.api.page.FrameId;
import java.lang.Void;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.RequiredArgsConstructor;

/**
 * Defines commands and events for Autofill.
 */
@RequiredArgsConstructor
@Experimental
@Generated
public class Autofill {
  private final Session session;

  /**
   * Trigger autofill on a form identified by the fieldId.
   * If the field and related form cannot be autofilled, returns an error.
   */
  public CompletableFuture<Void> trigger(TriggerRequest request) {
    return session.send("Autofill.trigger", request, Void.class);
  }

  /**
   * Set addresses so that developers can verify their forms implementation.
   */
  public CompletableFuture<Void> setAddresses(SetAddressesRequest request) {
    return session.send("Autofill.setAddresses", request, Void.class);
  }

  /**
   * Disables autofill domain notifications.
   */
  public CompletableFuture<Void> disable() {
    return session.send("Autofill.disable", null, Void.class);
  }

  /**
   * Enables autofill domain notifications.
   */
  public CompletableFuture<Void> enable() {
    return session.send("Autofill.enable", null, Void.class);
  }

  public Disposable onAddressFormFilled(Consumer<AddressFormFilledEvent> listener) {
    return session.subscribe("Autofill.addressFormFilled", listener, AddressFormFilledEvent.class);
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class TriggerRequest {
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
  public static class SetAddressesRequest {
    private final List<Address> addresses;
  }

  /**
   * Emitted when an address form is filled.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class AddressFormFilledEvent {
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
