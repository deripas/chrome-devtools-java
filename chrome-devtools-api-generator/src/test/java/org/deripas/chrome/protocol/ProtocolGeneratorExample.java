package org.deripas.chrome.protocol;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProtocolGeneratorExample {

    public static void main(String[] args) {
        final ProtocolGenerator generator = new ProtocolGenerator("org.deripas.chrome.protocol.api");
        generator.add(ProtocolReader.read("protocol/browser_protocol.json"));
        generator.add(ProtocolReader.read("protocol/js_protocol.json"));
        generator.generateJavaFiles()
            .forEach(f -> log.info("Generated: {}", f.toString()));
    }
}
