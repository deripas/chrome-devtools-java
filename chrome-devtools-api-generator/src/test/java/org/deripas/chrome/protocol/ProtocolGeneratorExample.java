package org.deripas.chrome.protocol;

import lombok.extern.slf4j.Slf4j;
import picocli.CommandLine;

@Slf4j
public class ProtocolGeneratorExample {

    public static void main(String[] args) {
        new CommandLine(new ProtocolGeneratorCommand())
            .execute(
                "-p", "org.deripas.chrome.protocol.api",
                "-o", "chrome-devtools-api/src/main/generated-java",
                "--dry-run",
                "protocol/browser_protocol.json",
                "protocol/js_protocol.json"
            );
    }
}
