package org.deripas.chrome.protocol.api.audits;

import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * This issue tracks information needed to print a deprecation message.
 * https://source.chromium.org/chromium/chromium/src/+/main:third_party/blink/renderer/core/frame/third_party/blink/renderer/core/frame/deprecation/README.md
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class DeprecationIssueDetails {
  @Nullable
  private final AffectedFrame affectedFrame;

  private final SourceCodeLocation sourceCodeLocation;

  /**
   * One of the deprecation names from third_party/blink/renderer/core/frame/deprecation/deprecation.json5
   */
  private final String type;
}
