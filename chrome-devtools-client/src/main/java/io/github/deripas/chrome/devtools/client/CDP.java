package io.github.deripas.chrome.devtools.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.deripas.chrome.devtools.api.Session;
import io.github.deripas.chrome.devtools.api.Transport;
import io.github.deripas.chrome.devtools.api.session.RootSession;
import lombok.RequiredArgsConstructor;
import io.github.deripas.chrome.devtools.client.transport.http.JdkHttpClient;

import java.net.URI;
import java.net.http.HttpClient;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;

@RequiredArgsConstructor
public class CDP {

    private final CDPClient client;
    private final Function<Transport, Session> factory;

    public static CDP createDefault() {
        final HttpClient httpClient = HttpClient.newHttpClient();
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.configure(FAIL_ON_UNKNOWN_PROPERTIES, false);
        final CDPClient client = new JdkHttpClient(httpClient, objectMapper);
        return new CDP(client, transport -> new RootSession(transport, objectMapper));
    }

    public CompletableFuture<Session> connect(URI url) {
        return getTransport(url).thenApply(factory);
    }

    private CompletableFuture<Transport> getTransport(URI url) {
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
