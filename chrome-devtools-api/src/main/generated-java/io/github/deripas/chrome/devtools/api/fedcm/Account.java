package io.github.deripas.chrome.devtools.api.fedcm;

import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Corresponds to IdentityRequestAccount
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class Account {
  private final String accountId;

  private final String email;

  private final String name;

  private final String givenName;

  private final String pictureUrl;

  private final String idpConfigUrl;

  private final String idpLoginUrl;

  private final LoginState loginState;

  /**
   * These two are only set if the loginState is signUp
   */
  @Nullable
  private final String termsOfServiceUrl;

  @Nullable
  private final String privacyPolicyUrl;
}
