package io.github.deripas.chrome.devtools.api.browser;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.String;
import jdk.jfr.Experimental;
import lombok.Generated;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor(
    staticName = "of",
    onConstructor_ = @JsonCreator
)
@Getter(
    onMethod_ = @JsonValue
)
@Experimental
@Generated
public class BrowserContextID {
  String value;
}
