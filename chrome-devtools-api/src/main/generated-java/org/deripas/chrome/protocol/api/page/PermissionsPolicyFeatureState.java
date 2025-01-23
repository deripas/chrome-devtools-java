package org.deripas.chrome.protocol.api.page;

import java.lang.Boolean;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class PermissionsPolicyFeatureState {
  private final PermissionsPolicyFeature feature;

  private final Boolean allowed;

  @Nullable
  private final PermissionsPolicyBlockLocator locator;
}
