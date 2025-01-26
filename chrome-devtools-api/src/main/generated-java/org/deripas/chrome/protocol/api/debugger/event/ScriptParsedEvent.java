package org.deripas.chrome.protocol.api.debugger.event;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.debugger.DebugSymbols;
import org.deripas.chrome.protocol.api.debugger.ScriptLanguage;
import org.deripas.chrome.protocol.api.runtime.ExecutionContextId;
import org.deripas.chrome.protocol.api.runtime.ScriptId;
import org.deripas.chrome.protocol.api.runtime.StackTrace;

/**
 * Fired when virtual machine parses script. This event is also fired for all known and uncollected
 * scripts upon enabling debugger.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ScriptParsedEvent {
  public static final EventId<ScriptParsedEvent> ID = new EventId<>("Debugger.scriptParsed", ScriptParsedEvent.class);

  /**
   * Identifier of the script parsed.
   */
  private final ScriptId scriptId;

  /**
   * URL or name of the script parsed (if any).
   */
  private final String url;

  /**
   * Line offset of the script within the resource with given URL (for script tags).
   */
  private final Integer startLine;

  /**
   * Column offset of the script within the resource with given URL.
   */
  private final Integer startColumn;

  /**
   * Last line of the script.
   */
  private final Integer endLine;

  /**
   * Length of the last line of the script.
   */
  private final Integer endColumn;

  /**
   * Specifies script creation context.
   */
  private final ExecutionContextId executionContextId;

  /**
   * Content hash of the script, SHA-256.
   */
  private final String hash;

  /**
   * For Wasm modules, the content of the `build_id` custom section.
   */
  private final String buildId;

  /**
   * Embedder-specific auxiliary data likely matching {isDefault: boolean, type: 'default'|'isolated'|'worker', frameId: string}
   */
  @Nullable
  private final Map executionContextAuxData;

  /**
   * True, if this script is generated as a result of the live edit operation.
   */
  @Nullable
  @Experimental
  private final Boolean isLiveEdit;

  /**
   * URL of source map associated with script (if any).
   */
  @Nullable
  private final String sourceMapURL;

  /**
   * True, if this script has sourceURL.
   */
  @Nullable
  private final Boolean hasSourceURL;

  /**
   * True, if this script is ES6 module.
   */
  @Nullable
  private final Boolean isModule;

  /**
   * This script length.
   */
  @Nullable
  private final Integer length;

  /**
   * JavaScript top stack frame of where the script parsed event was triggered if available.
   */
  @Nullable
  @Experimental
  private final StackTrace stackTrace;

  /**
   * If the scriptLanguage is WebAssembly, the code section offset in the module.
   */
  @Nullable
  @Experimental
  private final Integer codeOffset;

  /**
   * The language of the script.
   */
  @Nullable
  @Experimental
  private final ScriptLanguage scriptLanguage;

  /**
   * If the scriptLanguage is WebAssembly, the source of debug symbols for the module.
   */
  @Nullable
  @Experimental
  private final List<DebugSymbols> debugSymbols;

  /**
   * The name the embedder supplied for this script.
   */
  @Nullable
  @Experimental
  private final String embedderName;
}
