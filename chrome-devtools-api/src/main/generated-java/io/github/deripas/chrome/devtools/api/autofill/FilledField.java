package io.github.deripas.chrome.devtools.api.autofill;

import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import io.github.deripas.chrome.devtools.api.dom.BackendNodeId;
import io.github.deripas.chrome.devtools.api.page.FrameId;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class FilledField {
  /**
   * The type of the field, e.g text, password etc.
   */
  private final String htmlType;

  /**
   * the html id
   */
  private final String id;

  /**
   * the html name
   */
  private final String name;

  /**
   * the field value
   */
  private final String value;

  /**
   * The actual field type, e.g FAMILY_NAME
   */
  private final String autofillType;

  /**
   * The filling strategy
   */
  private final FillingStrategy fillingStrategy;

  /**
   * The frame the field belongs to
   */
  private final FrameId frameId;

  /**
   * The form field's DOM node
   */
  private final BackendNodeId fieldId;
}
