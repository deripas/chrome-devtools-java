package org.deripas.chrome.protocol.api.target;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.List;
import jdk.jfr.Experimental;
import lombok.Generated;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;

/**
 * The entries in TargetFilter are matched sequentially against targets and
 * the first entry that matches determines if the target is included or not,
 * depending on the value of `exclude` field in the entry.
 * If filter is not specified, the one assumed is
 * [{type: "browser", exclude: true}, {type: "tab", exclude: true}, {}]
 * (i.e. include everything but `browser` and `tab`).
 */
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
public class TargetFilter {
  List<FilterEntry> value;
}
