package org.deripas.chrome.protocol.api.pwa;

import java.lang.String;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class FileHandler {
  private final String action;

  private final List<FileHandlerAccept> accepts;

  private final String displayName;
}
