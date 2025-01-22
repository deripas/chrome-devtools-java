package org.deripas.chrome.protocol.api.preload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.String;
import lombok.Generated;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;

/**
 * Chrome manages different types of preloads together using a
 * concept of preloading pipeline. For example, if a site uses a
 * SpeculationRules for prerender, Chrome first starts a prefetch and
 * then upgrades it to prerender.
 *
 * CDP events for them are emitted separately but they share
 * `PreloadPipelineId`.
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
public class PreloadPipelineId {
  String value;
}
