package io.github.deripas.chrome.protocol;

import io.github.deripas.chrome.protocol.Protocol.Version;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProtocolReaderTest {

    private final static Version V1_3 = new Version(1, 3);

    @Test
    void testBrowserProtocol() {
        final Protocol protocol = ProtocolReader.read(
            load("browser_protocol.json")
        );
        assertEquals(V1_3, protocol.version());
        assertEquals(47, protocol.domains().size());
        // TODO: add more assertions
    }

    @Test
    void testJsProtocol() {
        final Protocol protocol = ProtocolReader.read(
            load("js_protocol.json")
        );
        assertEquals(V1_3, protocol.version());
        assertEquals(6, protocol.domains().size());
        // TODO: add more assertions
    }

    private static Reader load(String name) {
        final InputStream inputStream = ClassLoader.getSystemResourceAsStream(name);
        return new InputStreamReader(
            Objects.requireNonNull(inputStream)
        );
    }
}