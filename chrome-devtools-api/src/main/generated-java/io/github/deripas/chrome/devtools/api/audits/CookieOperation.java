package io.github.deripas.chrome.devtools.api.audits;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

@Generated
public enum CookieOperation {
  @JsonProperty("SetCookie")
  SET_COOKIE,

  @JsonProperty("ReadCookie")
  READ_COOKIE
}
