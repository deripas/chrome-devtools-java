package io.github.deripas.chrome.protocol;

import lombok.extern.slf4j.Slf4j;
import picocli.CommandLine;

@Slf4j
public class ProtocolGeneratorExample {

    public static void main(String[] args) {
        new CommandLine(new ProtocolGeneratorCommand())
            .execute(
                "-p", "io.github.deripas.chrome.devtools.api",
                "-o", "chrome-devtools-api/src/main/generated-java",
                "--dry-run",
                "protocol/browser_protocol.json",
                "protocol/js_protocol.json"
            );
    }
}
