package org.deripas.chrome.protocol.api.page;

import java.lang.String;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Generic font families collection.
 */
@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class FontFamilies {
  /**
   * The standard font-family.
   */
  @Nullable
  private final String standard;

  /**
   * The fixed font-family.
   */
  @Nullable
  private final String fixed;

  /**
   * The serif font-family.
   */
  @Nullable
  private final String serif;

  /**
   * The sansSerif font-family.
   */
  @Nullable
  private final String sansSerif;

  /**
   * The cursive font-family.
   */
  @Nullable
  private final String cursive;

  /**
   * The fantasy font-family.
   */
  @Nullable
  private final String fantasy;

  /**
   * The math font-family.
   */
  @Nullable
  private final String math;
}
