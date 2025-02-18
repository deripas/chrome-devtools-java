package io.github.deripas.chrome.devtools.api.audits;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

@Generated
public enum SRIMessageSignatureError {
  @JsonProperty("MissingSignatureHeader")
  MISSING_SIGNATURE_HEADER,

  @JsonProperty("MissingSignatureInputHeader")
  MISSING_SIGNATURE_INPUT_HEADER,

  @JsonProperty("InvalidSignatureHeader")
  INVALID_SIGNATURE_HEADER,

  @JsonProperty("InvalidSignatureInputHeader")
  INVALID_SIGNATURE_INPUT_HEADER,

  @JsonProperty("SignatureHeaderValueIsNotByteSequence")
  SIGNATURE_HEADER_VALUE_IS_NOT_BYTE_SEQUENCE,

  @JsonProperty("SignatureHeaderValueIsParameterized")
  SIGNATURE_HEADER_VALUE_IS_PARAMETERIZED,

  @JsonProperty("SignatureHeaderValueIsIncorrectLength")
  SIGNATURE_HEADER_VALUE_IS_INCORRECT_LENGTH,

  @JsonProperty("SignatureInputHeaderMissingLabel")
  SIGNATURE_INPUT_HEADER_MISSING_LABEL,

  @JsonProperty("SignatureInputHeaderValueNotInnerList")
  SIGNATURE_INPUT_HEADER_VALUE_NOT_INNER_LIST,

  @JsonProperty("SignatureInputHeaderValueMissingComponents")
  SIGNATURE_INPUT_HEADER_VALUE_MISSING_COMPONENTS,

  @JsonProperty("SignatureInputHeaderInvalidComponentType")
  SIGNATURE_INPUT_HEADER_INVALID_COMPONENT_TYPE,

  @JsonProperty("SignatureInputHeaderInvalidComponentName")
  SIGNATURE_INPUT_HEADER_INVALID_COMPONENT_NAME,

  @JsonProperty("SignatureInputHeaderInvalidHeaderComponentParameter")
  SIGNATURE_INPUT_HEADER_INVALID_HEADER_COMPONENT_PARAMETER,

  @JsonProperty("SignatureInputHeaderInvalidDerivedComponentParameter")
  SIGNATURE_INPUT_HEADER_INVALID_DERIVED_COMPONENT_PARAMETER,

  @JsonProperty("SignatureInputHeaderKeyIdLength")
  SIGNATURE_INPUT_HEADER_KEY_ID_LENGTH,

  @JsonProperty("SignatureInputHeaderInvalidParameter")
  SIGNATURE_INPUT_HEADER_INVALID_PARAMETER,

  @JsonProperty("SignatureInputHeaderMissingRequiredParameters")
  SIGNATURE_INPUT_HEADER_MISSING_REQUIRED_PARAMETERS,

  @JsonProperty("ValidationFailedSignatureExpired")
  VALIDATION_FAILED_SIGNATURE_EXPIRED,

  @JsonProperty("ValidationFailedInvalidLength")
  VALIDATION_FAILED_INVALID_LENGTH,

  @JsonProperty("ValidationFailedSignatureMismatch")
  VALIDATION_FAILED_SIGNATURE_MISMATCH
}
