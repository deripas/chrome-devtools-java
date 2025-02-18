package io.github.deripas.chrome.devtools.api.debugger;

import java.lang.Integer;
import java.lang.String;
import java.util.List;
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
public class WasmDisassemblyChunk {
  /**
   * The next chunk of disassembled lines.
   */
  private final List<String> lines;

  /**
   * The bytecode offsets describing the start of each line.
   */
  private final List<Integer> bytecodeOffsets;
}
