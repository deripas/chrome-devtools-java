package io.github.deripas.chrome.devtools.api.audits;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

@Generated
public enum AttributionReportingIssueType {
  @JsonProperty("PermissionPolicyDisabled")
  PERMISSION_POLICY_DISABLED,

  @JsonProperty("UntrustworthyReportingOrigin")
  UNTRUSTWORTHY_REPORTING_ORIGIN,

  @JsonProperty("InsecureContext")
  INSECURE_CONTEXT,

  @JsonProperty("InvalidHeader")
  INVALID_HEADER,

  @JsonProperty("InvalidRegisterTriggerHeader")
  INVALID_REGISTER_TRIGGER_HEADER,

  @JsonProperty("SourceAndTriggerHeaders")
  SOURCE_AND_TRIGGER_HEADERS,

  @JsonProperty("SourceIgnored")
  SOURCE_IGNORED,

  @JsonProperty("TriggerIgnored")
  TRIGGER_IGNORED,

  @JsonProperty("OsSourceIgnored")
  OS_SOURCE_IGNORED,

  @JsonProperty("OsTriggerIgnored")
  OS_TRIGGER_IGNORED,

  @JsonProperty("InvalidRegisterOsSourceHeader")
  INVALID_REGISTER_OS_SOURCE_HEADER,

  @JsonProperty("InvalidRegisterOsTriggerHeader")
  INVALID_REGISTER_OS_TRIGGER_HEADER,

  @JsonProperty("WebAndOsHeaders")
  WEB_AND_OS_HEADERS,

  @JsonProperty("NoWebOrOsSupport")
  NO_WEB_OR_OS_SUPPORT,

  @JsonProperty("NavigationRegistrationWithoutTransientUserActivation")
  NAVIGATION_REGISTRATION_WITHOUT_TRANSIENT_USER_ACTIVATION,

  @JsonProperty("InvalidInfoHeader")
  INVALID_INFO_HEADER,

  @JsonProperty("NoRegisterSourceHeader")
  NO_REGISTER_SOURCE_HEADER,

  @JsonProperty("NoRegisterTriggerHeader")
  NO_REGISTER_TRIGGER_HEADER,

  @JsonProperty("NoRegisterOsSourceHeader")
  NO_REGISTER_OS_SOURCE_HEADER,

  @JsonProperty("NoRegisterOsTriggerHeader")
  NO_REGISTER_OS_TRIGGER_HEADER,

  @JsonProperty("NavigationRegistrationUniqueScopeAlreadySet")
  NAVIGATION_REGISTRATION_UNIQUE_SCOPE_ALREADY_SET
}
