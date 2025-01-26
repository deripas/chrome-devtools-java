package org.deripas.chrome.protocol.api.security.event;

import java.lang.Boolean;
import java.lang.Deprecated;
import java.lang.String;
import java.util.List;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.security.InsecureContentStatus;
import org.deripas.chrome.protocol.api.security.SecurityState;
import org.deripas.chrome.protocol.api.security.SecurityStateExplanation;

/**
 * The security state of the page changed. No longer being sent.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class SecurityStateChangedEvent {
  public static final EventId<SecurityStateChangedEvent> ID = new EventId<>("Security.securityStateChanged", SecurityStateChangedEvent.class);

  /**
   * Security state.
   */
  private final SecurityState securityState;

  /**
   * True if the page was loaded over cryptographic transport such as HTTPS.
   */
  @Deprecated
  private final Boolean schemeIsCryptographic;

  /**
   * Previously a list of explanations for the security state. Now always
   * empty.
   */
  @Deprecated
  private final List<SecurityStateExplanation> explanations;

  /**
   * Information about insecure content on the page.
   */
  @Deprecated
  private final InsecureContentStatus insecureContentStatus;

  /**
   * Overrides user-visible description of the state. Always omitted.
   */
  @Nullable
  @Deprecated
  private final String summary;
}
