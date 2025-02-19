package io.github.deripas.chrome.devtools.api.io;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.String;
import lombok.Generated;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;

/**
 * This is either obtained from another method or specified as `blob:&lt;uuid&gt;` where
 * `&lt;uuid&gt;` is an UUID of a Blob.
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
public class StreamHandle {
  String value;
}
