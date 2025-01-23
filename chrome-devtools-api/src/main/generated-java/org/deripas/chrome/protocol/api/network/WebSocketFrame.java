package org.deripas.chrome.protocol.api.network;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * WebSocket message data. This represents an entire WebSocket message, not just a fragmented frame as the name suggests.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class WebSocketFrame {
  /**
   * WebSocket message opcode.
   */
  private final Long opcode;

  /**
   * WebSocket message mask.
   */
  private final Boolean mask;

  /**
   * WebSocket message payload data.
   * If the opcode is 1, this is a text message and payloadData is a UTF-8 string.
   * If the opcode isn't 1, then payloadData is a base64 encoded string representing binary data.
   */
  private final String payloadData;
}
