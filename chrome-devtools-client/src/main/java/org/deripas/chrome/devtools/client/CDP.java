package org.deripas.chrome.devtools.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.deripas.chrome.devtools.client.session.CDPSession;
import org.deripas.chrome.devtools.client.transport.CDPTransport;
import org.deripas.chrome.devtools.client.session.SessionFactory;
import org.deripas.chrome.devtools.client.transport.CDPClient;
import org.deripas.chrome.devtools.client.transport.http.HttpCDPClient;

import java.net.URI;
import java.net.http.HttpClient;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;

@RequiredArgsConstructor
public class CDP {

    private final CDPClient client;
    private final Function<CDPTransport, CDPSession> factory;

    public static CDP create() {
        final HttpClient httpClient = HttpClient.newHttpClient();
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.configure(FAIL_ON_UNKNOWN_PROPERTIES, false);
        final CDPClient client = new HttpCDPClient(httpClient, objectMapper, Duration.ofSeconds(30));
        final SessionFactory sessionFactory = new SessionFactory(objectMapper);
        return new CDP(client, sessionFactory::create);
    }

    public CompletableFuture<CDPSession> http(URI httpUrl) {
        return client.http(httpUrl)
            .thenApply(factory);
    }

    public CompletableFuture<CDPSession> websocket(URI wsUrl) {
        return client.websocket(wsUrl)
            .thenApply(factory);
    }
}
