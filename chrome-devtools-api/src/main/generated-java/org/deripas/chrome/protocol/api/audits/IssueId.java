package org.deripas.chrome.protocol.api.audits;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.String;
import lombok.Generated;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;

/**
 * A unique id for a DevTools inspector issue. Allows other entities (e.g.
 * exceptions, CDP message, console messages, etc.) to reference an issue.
 */
@Value
@RequiredArgsConstructor(
    staticName = "of",
    onConstructor_ = @JsonCreator
)
@Getter(
    onMethod_ = @JsonValue
)
@Generated
public class IssueId {
  String value;
}
