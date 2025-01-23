package org.deripas.chrome.protocol.api.css;

import java.lang.Boolean;
import java.lang.String;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.dom.LogicalAxes;
import org.deripas.chrome.protocol.api.dom.PhysicalAxes;

/**
 * CSS container query rule descriptor.
 */
@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class CSSContainerQuery {
  /**
   * Container query text.
   */
  private final String text;

  /**
   * The associated rule header range in the enclosing stylesheet (if
   * available).
   */
  @Nullable
  private final SourceRange range;

  /**
   * Identifier of the stylesheet containing this object (if exists).
   */
  @Nullable
  private final StyleSheetId styleSheetId;

  /**
   * Optional name for the container.
   */
  @Nullable
  private final String name;

  /**
   * Optional physical axes queried for the container.
   */
  @Nullable
  private final PhysicalAxes physicalAxes;

  /**
   * Optional logical axes queried for the container.
   */
  @Nullable
  private final LogicalAxes logicalAxes;

  /**
   * true if the query contains scroll-state() queries.
   */
  @Nullable
  private final Boolean queriesScrollState;
}
