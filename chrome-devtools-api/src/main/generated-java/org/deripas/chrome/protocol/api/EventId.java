package org.deripas.chrome.protocol.api;

import java.lang.Class;
import java.lang.String;
import lombok.Generated;

@Generated
public record EventId<T>(String method, Class<T> type) {
}
