package io.github.deripas.chrome.devtools.api.audits;

import java.lang.Deprecated;
import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Data
@Builder(
    toBuilder = true
)
@Deprecated
@Generated
public class NavigatorUserAgentIssueDetails {
  private final String url;

  @Nullable
  private final SourceCodeLocation location;
}
