package io.github.deripas.chrome.devtools.api.audits;

import io.github.deripas.chrome.devtools.api.runtime.ScriptId;
import java.lang.Integer;
import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

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
