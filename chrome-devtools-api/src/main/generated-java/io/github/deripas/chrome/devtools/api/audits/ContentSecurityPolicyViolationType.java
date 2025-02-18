package io.github.deripas.chrome.devtools.api.audits;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

@Generated
public enum ContentSecurityPolicyViolationType {
  @JsonProperty("kInlineViolation")
  K_INLINE_VIOLATION,

  @JsonProperty("kEvalViolation")
  K_EVAL_VIOLATION,

  @JsonProperty("kURLViolation")
  K_U_R_L_VIOLATION,

  @JsonProperty("kSRIViolation")
  K_S_R_I_VIOLATION,

  @JsonProperty("kTrustedTypesSinkViolation")
  K_TRUSTED_TYPES_SINK_VIOLATION,

  @JsonProperty("kTrustedTypesPolicyViolation")
  K_TRUSTED_TYPES_POLICY_VIOLATION,

  @JsonProperty("kWasmEvalViolation")
  K_WASM_EVAL_VIOLATION
}
