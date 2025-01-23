package org.deripas.chrome.protocol.api.audits;

import java.lang.Integer;
import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.runtime.ScriptId;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class SourceCodeLocation {
  @Nullable
  private final ScriptId scriptId;

  private final String url;

  private final Integer lineNumber;

  private final Integer columnNumber;
}
