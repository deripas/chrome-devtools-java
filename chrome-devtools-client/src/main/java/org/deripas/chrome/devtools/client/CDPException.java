package org.deripas.chrome.devtools.client;

import lombok.Getter;
import org.deripas.chrome.devtools.client.transport.CDPTransport;

@Getter
public class CDPException extends RuntimeException {

    private final CDPTransport.Error error;

    public CDPException(CDPTransport.Error error) {
        super(error.message(), null, false, false);
        this.error = error;
    }
}