package org.deripas.chrome.protocol.api.page.event;

import java.lang.Boolean;
import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.page.DialogType;

/**
 * Fired when a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload) is about to
 * open.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class JavascriptDialogOpeningEvent {
  public static final EventId<JavascriptDialogOpeningEvent> ID = new EventId<>("Page.javascriptDialogOpening", JavascriptDialogOpeningEvent.class);

  /**
   * Frame url.
   */
  private final String url;

  /**
   * Message that will be displayed by the dialog.
   */
  private final String message;

  /**
   * Dialog type.
   */
  private final DialogType type;

  /**
   * True iff browser is capable showing or acting on the given dialog. When browser has no
   * dialog handler for given target, calling alert while Page domain is engaged will stall
   * the page execution. Execution can be resumed via calling Page.handleJavaScriptDialog.
   */
  private final Boolean hasBrowserHandler;

  /**
   * Default dialog prompt.
   */
  @Nullable
  private final String defaultPrompt;
}
