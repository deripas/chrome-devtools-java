package io.github.deripas.chrome.devtools.api.dom;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Double;
import java.util.List;
import lombok.Generated;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;

/**
 * An array of quad vertices, x immediately followed by y for each point, points clock-wise.
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
public class Quad {
  List<Double> value;
}
