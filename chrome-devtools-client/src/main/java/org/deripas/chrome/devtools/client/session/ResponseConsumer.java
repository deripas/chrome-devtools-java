package org.deripas.chrome.devtools.client.session;

import lombok.Getter;
import org.deripas.chrome.devtools.client.CDPException;
import org.deripas.chrome.devtools.client.transport.CDPTransport;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

@Getter
public class ResponseConsumer implements Consumer<CDPTransport.Response> {

    private final CompletableFuture<CDPTransport.Response> future = new CompletableFuture<>();

    @Override
    public void accept(CDPTransport.Response response) {
        if (response.error() != null) {
            future.completeExceptionally(new CDPException(response.error()));
        } else {
            future.complete(response);
        }
    }
}
