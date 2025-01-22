package org.deripas.chrome.protocol.api.autofill;

import java.util.List;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
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
  void trigger(TriggerRequest request);

  /**
   * Set addresses so that developers can verify their forms implementation.
   */
  void setAddresses(SetAddressesRequest request);

  /**
   * Disables autofill domain notifications.
   */
  void disable();

  /**
   * Enables autofill domain notifications.
   */
  void enable();

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
}
