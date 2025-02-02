import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.deripas.chrome.devtools.client.DSL;
import org.deripas.chrome.devtools.client.dsl.BrowserContextDsl;
import org.deripas.chrome.devtools.client.dsl.BrowserDsl;
import org.deripas.chrome.devtools.client.dsl.PageDsl;
import org.deripas.chrome.devtools.client.dsl.PageResponse;
import org.deripas.chrome.protocol.api.page.Page;

import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
public class MainDsl {

    @SneakyThrows
    public static void main(String[] args) {
        try (final BrowserDsl browser = DSL.connect("http://localhost:9222")) {
            final BrowserContextDsl context = browser.createContext();
            context.setIgnoreCertificateErrors(true);
            final PageDsl page = context.createPage();
            final PageResponse response = page.navigate("https://expired.badssl.com/");
        }
    }
}