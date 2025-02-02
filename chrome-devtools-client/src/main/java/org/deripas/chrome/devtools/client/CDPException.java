package org.deripas.chrome.devtools.client;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import org.deripas.chrome.devtools.client.transport.CDPTransport;

@Getter
public class CDPException extends RuntimeException {

    private final Long code;
    private final String message;
    private final JsonNode data;

    public CDPException(CDPTransport.Error error) {
        super(error.message(), null, false, false);
        this.message = error.message();
        this.code = error.code();
        this.data = error.data();
    }

    public CDPException(String error) {
        super(error, null, false, false);
        this.message = error;
        this.code = null;
        this.data = null;
    }
}