import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import io.github.deripas.chrome.devtools.client.DSL;
import io.github.deripas.chrome.devtools.client.dsl.BrowserContextDsl;
import io.github.deripas.chrome.devtools.client.dsl.BrowserDsl;
import io.github.deripas.chrome.devtools.client.dsl.PageDsl;
import io.github.deripas.chrome.devtools.api.page.Page;

import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
public class ExampleCaptureScreenshotDsl {

    @SneakyThrows
    public static void main(String[] args) {
        try(final BrowserDsl browser = DSL.connect("ws://localhost:8222/devtools/browser")) {
            final BrowserContextDsl context = browser.createContext();
            final PageDsl page = context.createPage();
            page.navigate("https://www.google.com");
            Thread.sleep(1_000);
            byte[] bytes = page.screenshot(Page.CaptureScreenshotRequest.Format.PNG);
            Files.write(Path.of("screenshot.png"), bytes);
        }
    }
}
