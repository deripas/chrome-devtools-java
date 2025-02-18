package io.github.deripas.chrome.devtools.api.autofill;

import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class CreditCard {
  /**
   * 16-digit credit card number.
   */
  private final String number;

  /**
   * Name of the credit card owner.
   */
  private final String name;

  /**
   * 2-digit expiry month.
   */
  private final String expiryMonth;

  /**
   * 4-digit expiry year.
   */
  private final String expiryYear;

  /**
   * 3-digit card verification code.
   */
  private final String cvc;
}
