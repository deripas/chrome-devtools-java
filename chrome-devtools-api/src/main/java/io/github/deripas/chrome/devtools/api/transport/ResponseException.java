package io.github.deripas.chrome.devtools.api.transport;

import com.fasterxml.jackson.databind.JsonNode;
import io.github.deripas.chrome.devtools.api.transport.Response.Error;
import lombok.Getter;

@Getter
public class ResponseException extends RuntimeException {

    private final Long code;
    private final String message;
    private final JsonNode data;

    public ResponseException(Error error) {
        super(error.getMessage(), null, false, false);
        this.message = error.getMessage();
        this.code = error.getCode();
        this.data = error.getData();
    }
}
