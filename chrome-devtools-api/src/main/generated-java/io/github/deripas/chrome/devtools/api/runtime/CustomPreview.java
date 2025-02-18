package io.github.deripas.chrome.devtools.api.runtime;

import java.lang.String;
import javax.annotation.Nullable;
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
public class CustomPreview {
  /**
   * The JSON-stringified result of formatter.header(object, config) call.
   * It contains json ML array that represents RemoteObject.
   */
  private final String header;

  /**
   * If formatter returns true as a result of formatter.hasBody call then bodyGetterId will
   * contain RemoteObjectId for the function that returns result of formatter.body(object, config) call.
   * The result value is json ML array.
   */
  @Nullable
  private final RemoteObjectId bodyGetterId;
}
