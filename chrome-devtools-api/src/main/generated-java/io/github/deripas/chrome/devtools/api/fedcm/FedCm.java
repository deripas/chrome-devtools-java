package io.github.deripas.chrome.devtools.api.fedcm;

import io.github.deripas.chrome.devtools.api.Disposable;
import io.github.deripas.chrome.devtools.api.Session;
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
import lombok.RequiredArgsConstructor;

/**
 * This domain allows interacting with the FedCM dialog.
 */
@RequiredArgsConstructor
@Experimental
@Generated
public class FedCm {
  private final Session session;

  public CompletableFuture<Void> enable(EnableRequest request) {
    return session.send("FedCm.enable", request, Void.class);
  }

  public CompletableFuture<Void> disable() {
    return session.send("FedCm.disable", null, Void.class);
  }

  public CompletableFuture<Void> selectAccount(SelectAccountRequest request) {
    return session.send("FedCm.selectAccount", request, Void.class);
  }

  public CompletableFuture<Void> clickDialogButton(ClickDialogButtonRequest request) {
    return session.send("FedCm.clickDialogButton", request, Void.class);
  }

  public CompletableFuture<Void> openUrl(OpenUrlRequest request) {
    return session.send("FedCm.openUrl", request, Void.class);
  }

  public CompletableFuture<Void> dismissDialog(DismissDialogRequest request) {
    return session.send("FedCm.dismissDialog", request, Void.class);
  }

  /**
   * Resets the cooldown time, if any, to allow the next FedCM call to show
   * a dialog even if one was recently dismissed by the user.
   */
  public CompletableFuture<Void> resetCooldown() {
    return session.send("FedCm.resetCooldown", null, Void.class);
  }

  public Disposable onDialogShown(Consumer<DialogShownEvent> listener) {
    return session.subscribe("FedCm.dialogShown", listener, DialogShownEvent.class);
  }

  public Disposable onDialogClosed(Consumer<DialogClosedEvent> listener) {
    return session.subscribe("FedCm.dialogClosed", listener, DialogClosedEvent.class);
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class EnableRequest {
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
  public static class SelectAccountRequest {
    private final String dialogId;

    private final Integer accountIndex;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class ClickDialogButtonRequest {
    private final String dialogId;

    private final DialogButton dialogButton;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class OpenUrlRequest {
    private final String dialogId;

    private final Integer accountIndex;

    private final AccountUrlType accountUrlType;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class DismissDialogRequest {
    private final String dialogId;

    @Nullable
    private final Boolean triggerCooldown;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class DialogShownEvent {
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
  public static class DialogClosedEvent {
    private final String dialogId;
  }
}
