package io.github.deripas.chrome.devtools.api.runtime;

import java.lang.String;
import java.util.Map;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Description of an isolated world.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ExecutionContextDescription {
  /**
   * Unique id of the execution context. It can be used to specify in which execution context
   * script evaluation should be performed.
   */
  private final ExecutionContextId id;

  /**
   * Execution context origin.
   */
  private final String origin;

  /**
   * Human readable name describing given context.
   */
  private final String name;

  /**
   * A system-unique execution context identifier. Unlike the id, this is unique across
   * multiple processes, so can be reliably used to identify specific context while backend
   * performs a cross-process navigation.
   */
  @Experimental
  private final String uniqueId;

  /**
   * Embedder-specific auxiliary data likely matching {isDefault: boolean, type: 'default'|'isolated'|'worker', frameId: string}
   */
  @Nullable
  private final Map auxData;
}
