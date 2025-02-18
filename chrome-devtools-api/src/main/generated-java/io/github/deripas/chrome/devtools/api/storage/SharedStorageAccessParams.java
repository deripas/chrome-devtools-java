package io.github.deripas.chrome.devtools.api.storage;

import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Bundles the parameters for shared storage access events whose
 * presence/absence can vary according to SharedStorageAccessType.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class SharedStorageAccessParams {
  /**
   * Spec of the module script URL.
   * Present only for SharedStorageAccessType.documentAddModule.
   */
  @Nullable
  private final String scriptSourceUrl;

  /**
   * Name of the registered operation to be run.
   * Present only for SharedStorageAccessType.documentRun and
   * SharedStorageAccessType.documentSelectURL.
   */
  @Nullable
  private final String operationName;

  /**
   * The operation's serialized data in bytes (converted to a string).
   * Present only for SharedStorageAccessType.documentRun and
   * SharedStorageAccessType.documentSelectURL.
   */
  @Nullable
  private final String serializedData;

  /**
   * Array of candidate URLs' specs, along with any associated metadata.
   * Present only for SharedStorageAccessType.documentSelectURL.
   */
  @Nullable
  private final List<SharedStorageUrlWithMetadata> urlsWithMetadata;

  /**
   * Key for a specific entry in an origin's shared storage.
   * Present only for SharedStorageAccessType.documentSet,
   * SharedStorageAccessType.documentAppend,
   * SharedStorageAccessType.documentDelete,
   * SharedStorageAccessType.workletSet,
   * SharedStorageAccessType.workletAppend,
   * SharedStorageAccessType.workletDelete,
   * SharedStorageAccessType.workletGet,
   * SharedStorageAccessType.headerSet,
   * SharedStorageAccessType.headerAppend, and
   * SharedStorageAccessType.headerDelete.
   */
  @Nullable
  private final String key;

  /**
   * Value for a specific entry in an origin's shared storage.
   * Present only for SharedStorageAccessType.documentSet,
   * SharedStorageAccessType.documentAppend,
   * SharedStorageAccessType.workletSet,
   * SharedStorageAccessType.workletAppend,
   * SharedStorageAccessType.headerSet, and
   * SharedStorageAccessType.headerAppend.
   */
  @Nullable
  private final String value;

  /**
   * Whether or not to set an entry for a key if that key is already present.
   * Present only for SharedStorageAccessType.documentSet,
   * SharedStorageAccessType.workletSet, and
   * SharedStorageAccessType.headerSet.
   */
  @Nullable
  private final Boolean ignoreIfPresent;
}
