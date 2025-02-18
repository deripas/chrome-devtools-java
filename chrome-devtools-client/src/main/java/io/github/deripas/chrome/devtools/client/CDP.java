package io.github.deripas.chrome.devtools.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import io.github.deripas.chrome.devtools.client.session.SessionFactory;
import io.github.deripas.chrome.devtools.client.transport.http.HttpCDPClient;

import java.net.URI;
import java.net.http.HttpClient;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;

@RequiredArgsConstructor
public class CDP {

    private final CDPClient client;
    private final Function<CDPTransport, CDPSession> factory;

    public static CDP createDefault() {
        final HttpClient httpClient = HttpClient.newHttpClient();
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.configure(FAIL_ON_UNKNOWN_PROPERTIES, false);
        final CDPClient client = new HttpCDPClient(httpClient, objectMapper);
        final SessionFactory sessionFactory = new SessionFactory(objectMapper);
        return new CDP(client, sessionFactory::create);
    }

    public CompletableFuture<CDPSession> connect(URI url) {
        return getTransport(url).thenApply(factory);
    }

    private CompletableFuture<CDPTransport> getTransport(URI url) {
        final String scheme = url.getScheme();
        if (scheme.startsWith("ws")) {
            return client.websocket(url);
        }
        if (scheme.startsWith("http")) {
            return client.http(url);
        }
        throw new UnsupportedOperationException("Unsupported scheme: " + scheme);
    }
}
