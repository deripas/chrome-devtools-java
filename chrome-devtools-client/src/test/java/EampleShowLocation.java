import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.deripas.chrome.devtools.client.DSL;
import org.deripas.chrome.devtools.client.dsl.BrowserContextDsl;
import org.deripas.chrome.devtools.client.dsl.BrowserDsl;
import org.deripas.chrome.devtools.client.dsl.PageDsl;
import org.deripas.chrome.protocol.api.browser.PermissionType;
import org.deripas.chrome.protocol.api.page.Page;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

@Slf4j
public class EampleShowLocation {

    @SneakyThrows
    public static void main(String[] args) {
        try (final BrowserDsl browser = DSL.connect("http://localhost:9222")) {
            final BrowserContextDsl context = browser.createContext();
            context.grantPermissions(List.of(PermissionType.GEOLOCATION));
            context.setIgnoreCertificateErrors(true);

            final PageDsl page = context.createPage();
            page.setUserAgent("chrome-devtools-client");
            page.setLocale("en_US");
            page.setExtraHeaders(Map.of(
                "Accept-language", "en-GB;q=0.8, en;q=0.7"
            ));
            page.configureDevice(config -> config
                .width(411)
                .height(731)
                .deviceScaleFactor(2.625)
                .mobile(true));
            page.setGeolocation(40.7128, -74.0060, 10_000.0);
            page.navigate("https://www.openstreetmap.org/");

            Thread.sleep(1000);
            page.click("a[data-bs-original-title=\"Show My Location\"]");

            Thread.sleep(2000);
            byte[] bytes = page.screenshot(Page.CaptureScreenshotRequest.Format.PNG);
            Files.write(Path.of("screenshot.png"), bytes);
        }
    }
}