package org.deripas.chrome.protocol.api.systeminfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * YUV subsampling type of the pixels of a given image.
 */
@Generated
public enum SubsamplingFormat {
  @JsonProperty("yuv420")
  YUV420,

  @JsonProperty("yuv422")
  YUV422,

  @JsonProperty("yuv444")
  YUV444
}
