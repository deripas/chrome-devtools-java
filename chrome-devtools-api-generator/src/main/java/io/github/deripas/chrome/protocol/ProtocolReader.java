package io.github.deripas.chrome.protocol;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;

/**
 * Reads a protocol from a JSON file.
 */
@Slf4j
public class ProtocolReader {

    public static Protocol read(String protocolJsonFilePath) {
        return read(new File(protocolJsonFilePath));
    }

    @SneakyThrows
    public static Protocol read(File protocolJsonFile) {
        log.info("Reading protocol from: {}", protocolJsonFile);
        return read(new FileReader(protocolJsonFile));
    }

    @SneakyThrows
    public static Protocol read(Reader reader) {
        final ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(
            reader,
            Protocol.class
        );
    }
}
