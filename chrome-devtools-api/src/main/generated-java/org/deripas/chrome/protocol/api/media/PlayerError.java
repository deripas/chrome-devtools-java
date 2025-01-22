package org.deripas.chrome.protocol.api.media;

import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Map;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Corresponds to kMediaError
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class PlayerError {
  private final String errorType;

  /**
   * Code is the numeric enum entry for a specific set of error codes, such
   * as PipelineStatusCodes in media/base/pipeline_status.h
   */
  private final Integer code;

  /**
   * A trace of where this error was caused / where it passed through.
   */
  private final List<PlayerErrorSourceLocation> stack;

  /**
   * Errors potentially have a root cause error, ie, a DecoderError might be
   * caused by an WindowsError
   */
  private final List<PlayerError> cause;

  /**
   * Extra data attached to an error, such as an HRESULT, Video Codec, etc.
   */
  private final Map data;
}
