package io.github.deripas.chrome.devtools.api.fedcm;

import com.fasterxml.jackson.annotation.JsonTypeName;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.lang.Void;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import io.github.deripas.chrome.devtools.api.Disposable;

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

  Disposable onDialogShown(Consumer<DialogShownEvent> listener);

  Disposable onDialogClosed(Consumer<DialogClosedEvent> listener);

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

  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("dialogShown")
  class DialogShownEvent {
    private final String dialogId;

    private final DialogType dialogType;

    private final List<Account> accounts;

    /**
     * These exist primarily so that the caller can verify the
     * RP context was used appropriately.
     */
    private final String title;

    @Nullable
    private final String subtitle;
  }

  /**
   * Triggered when a dialog is closed, either by user action, JS abort,
   * or a command below.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("dialogClosed")
  class DialogClosedEvent {
    private final String dialogId;
  }
}
