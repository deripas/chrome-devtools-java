package org.deripas.chrome.protocol.api.fedcm.event;

import java.lang.String;
import java.util.List;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.fedcm.Account;
import org.deripas.chrome.protocol.api.fedcm.DialogType;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class DialogShownEvent {
  public static final EventId<DialogShownEvent> ID = new EventId<>("FedCm.dialogShown", DialogShownEvent.class);

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
