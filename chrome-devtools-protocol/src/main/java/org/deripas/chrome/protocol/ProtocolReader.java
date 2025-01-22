package org.deripas.chrome.protocol;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.FileReader;
import java.io.Reader;

@Slf4j
public class ProtocolReader {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @SneakyThrows
    public static Protocol read(String protocolJsonFilePath) {
        log.info("Reading protocol from: {}", protocolJsonFilePath);
        return read(new FileReader(protocolJsonFilePath));
    }

    @SneakyThrows
    public static Protocol read(Reader reader) {
        return OBJECT_MAPPER.readValue(
            reader,
            Protocol.class
        );
    }
}
