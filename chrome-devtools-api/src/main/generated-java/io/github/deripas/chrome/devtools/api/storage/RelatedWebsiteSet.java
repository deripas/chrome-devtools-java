package io.github.deripas.chrome.devtools.api.storage;

import java.lang.String;
import java.util.List;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * A single Related Website Set object.
 */
@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class RelatedWebsiteSet {
  /**
   * The primary site of this set, along with the ccTLDs if there is any.
   */
  private final List<String> primarySites;

  /**
   * The associated sites of this set, along with the ccTLDs if there is any.
   */
  private final List<String> associatedSites;

  /**
   * The service sites of this set, along with the ccTLDs if there is any.
   */
  private final List<String> serviceSites;
}
