package org.deripas.chrome.devtools.client.dsl;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PageResponse {
    private final Integer status;
    private final String body;
}
