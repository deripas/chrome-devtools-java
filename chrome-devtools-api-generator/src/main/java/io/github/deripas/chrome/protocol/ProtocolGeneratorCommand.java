package io.github.deripas.chrome.protocol;

import com.palantir.javapoet.JavaFile;
import lombok.Data;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import picocli.CommandLine;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

@CommandLine.Command(
    name = "generate",
    description = "Generate Chrome DevTools Protocol DTOs.",
    mixinStandardHelpOptions = true
)
@Slf4j
@Data
public class ProtocolGeneratorCommand implements Runnable {

    @CommandLine.Option(
        names = {"-p", "--package"},
        description = "Package name for generated classes.",
        defaultValue = "com.example.generated",
        showDefaultValue = CommandLine.Help.Visibility.ALWAYS
    )
    private String packageName;

    @CommandLine.Option(
        names = {"-d", "--dry-run"},
        description = "Dry run mode.",
        showDefaultValue = CommandLine.Help.Visibility.ALWAYS
    )
    private boolean dryRun;

    @CommandLine.Option(
        names = {"-o", "--output"},
        description = "Output directory for generated classes.",
        defaultValue = "src/main/generated-java",
        showDefaultValue = CommandLine.Help.Visibility.ALWAYS
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
        final Path javaFilePath = getFilePath(outputDir, javaFile);
        if (dryRun) {
            log.info("Dry run: {}", javaFilePath);
            return;
        }
        log.info("Write: {}", javaFilePath);
        javaFile.writeTo(outputDir);
    }

    private static Path getFilePath(File dir, JavaFile javaFile) {
        final String packageName = javaFile.packageName();
        final String className = javaFile.typeSpec().name();

        Path path = dir.toPath();
        if (!packageName.isEmpty()) {
            for (String packageComponent : packageName.split("\\.", -1)) {
                path = path.resolve(packageComponent);
            }
        }
        return path.resolve(className + ".java");
    }

    public static void main(String[] args) {
        new CommandLine(new ProtocolGeneratorCommand())
            .execute(args);
    }
}
