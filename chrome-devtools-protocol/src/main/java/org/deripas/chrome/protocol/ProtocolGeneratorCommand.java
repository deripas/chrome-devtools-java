package org.deripas.chrome.protocol;

import com.palantir.javapoet.JavaFile;
import lombok.SneakyThrows;
import picocli.CommandLine;

import java.io.File;
import java.util.List;

@CommandLine.Command(
    name = "generate",
    description = "Generate Chrome DevTools Protocol DTOs."
)
public class ProtocolGeneratorCommand implements Runnable {

    @CommandLine.Option(
        names = {"-p", "--package"},
        description = "Package name for generated classes.",
        defaultValue = "org.deripas.chrome.protocol.generated"
    )
    private String packageName;

    @CommandLine.Option(
        names = {"-o", "--output"},
        description = "Output directory for generated classes.",
        defaultValue = "src/main/java"
    )
    private File outputDir;

    @CommandLine.Parameters(
        description = "Protocol JSON files.",
        paramLabel = "files"
    )
    private List<File> protocolFiles;

    @Override
    public void run() {
        final ProtocolGenerator generator = new ProtocolGenerator(packageName);

        protocolFiles.stream()
            .map(ProtocolReader::read)
            .forEach(generator::add);

        generator.generateJavaFiles()
            .forEach(this::writeJavaFile);
    }

    @SneakyThrows
    private void writeJavaFile(JavaFile javaFile) {
        javaFile.writeTo(outputDir);
    }

    public static void main(String[] args) {
        new CommandLine(new ProtocolGeneratorCommand())
            .execute(args);
    }
}
