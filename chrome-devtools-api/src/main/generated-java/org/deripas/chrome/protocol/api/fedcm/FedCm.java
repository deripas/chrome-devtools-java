package org.deripas.chrome.protocol.api.fedcm;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.lang.Void;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * This domain allows interacting with the FedCM dialog.
 */
@Experimental
@Generated
public interface FedCm {
  CompletableFuture<Void> enable(EnableRequest request);

  CompletableFuture<Void> disable();

  CompletableFuture<Void> selectAccount(SelectAccountRequest request);

  CompletableFuture<Void> clickDialogButton(ClickDialogButtonRequest request);

  CompletableFuture<Void> openUrl(OpenUrlRequest request);

  CompletableFuture<Void> dismissDialog(DismissDialogRequest request);

  /**
   * Resets the cooldown time, if any, to allow the next FedCM call to show
   * a dialog even if one was recently dismissed by the user.
   */
  CompletableFuture<Void> resetCooldown();

  @Data
  @Builder(
      toBuilder = true
  )
  class EnableRequest {
    /**
     * Allows callers to disable the promise rejection delay that would
     * normally happen, if this is unimportant to what's being tested.
     * (step 4 of https://fedidcg.github.io/FedCM/#browser-api-rp-sign-in)
     */
    @Nullable
    private final Boolean disableRejectionDelay;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SelectAccountRequest {
    private final String dialogId;

    private final Integer accountIndex;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class ClickDialogButtonRequest {
    private final String dialogId;

    private final DialogButton dialogButton;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class OpenUrlRequest {
    private final String dialogId;

    private final Integer accountIndex;

    private final AccountUrlType accountUrlType;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class DismissDialogRequest {
    private final String dialogId;

    @Nullable
    private final Boolean triggerCooldown;
  }
}
