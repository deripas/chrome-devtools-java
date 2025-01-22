package org.deripas.chrome.protocol.api.audits;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

@Generated
public enum GenericIssueErrorType {
  @JsonProperty("FormLabelForNameError")
  FORM_LABEL_FOR_NAME_ERROR,

  @JsonProperty("FormDuplicateIdForInputError")
  FORM_DUPLICATE_ID_FOR_INPUT_ERROR,

  @JsonProperty("FormInputWithNoLabelError")
  FORM_INPUT_WITH_NO_LABEL_ERROR,

  @JsonProperty("FormAutocompleteAttributeEmptyError")
  FORM_AUTOCOMPLETE_ATTRIBUTE_EMPTY_ERROR,

  @JsonProperty("FormEmptyIdAndNameAttributesForInputError")
  FORM_EMPTY_ID_AND_NAME_ATTRIBUTES_FOR_INPUT_ERROR,

  @JsonProperty("FormAriaLabelledByToNonExistingId")
  FORM_ARIA_LABELLED_BY_TO_NON_EXISTING_ID,

  @JsonProperty("FormInputAssignedAutocompleteValueToIdOrNameAttributeError")
  FORM_INPUT_ASSIGNED_AUTOCOMPLETE_VALUE_TO_ID_OR_NAME_ATTRIBUTE_ERROR,

  @JsonProperty("FormLabelHasNeitherForNorNestedInput")
  FORM_LABEL_HAS_NEITHER_FOR_NOR_NESTED_INPUT,

  @JsonProperty("FormLabelForMatchesNonExistingIdError")
  FORM_LABEL_FOR_MATCHES_NON_EXISTING_ID_ERROR,

  @JsonProperty("FormInputHasWrongButWellIntendedAutocompleteValueError")
  FORM_INPUT_HAS_WRONG_BUT_WELL_INTENDED_AUTOCOMPLETE_VALUE_ERROR,

  @JsonProperty("ResponseWasBlockedByORB")
  RESPONSE_WAS_BLOCKED_BY_O_R_B
}
