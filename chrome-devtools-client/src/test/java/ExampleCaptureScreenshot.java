import io.github.deripas.chrome.devtools.api.Protocol;
import io.github.deripas.chrome.devtools.api.Session;
import io.github.deripas.chrome.devtools.api.page.Page;
import io.github.deripas.chrome.devtools.api.target.Target;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import io.github.deripas.chrome.devtools.client.CDP;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

@Slf4j
public class ExampleCaptureScreenshot {

    @SneakyThrows
    public static void main(String[] args) {
        Session session = CDP.createDefault()
            .connect(URI.create("http://localhost:8222"))
            .get();
        Protocol protocol = new Protocol(session);
        Target.CreateBrowserContextResponse browserContextResponse = protocol.getTarget()
            .createBrowserContext(Target.CreateBrowserContextRequest
                .builder()
                .disposeOnDetach(true)
                .build())
            .get();
        Target.CreateTargetResponse targetResponse = protocol.getTarget()
            .createTarget(Target.CreateTargetRequest.builder()
                .url("about:blank")
                .browserContextId(browserContextResponse.getBrowserContextId())
                .build())
            .get();
        Target.AttachToTargetResponse attachToTargetResponse = protocol.getTarget()
            .attachToTarget(Target.AttachToTargetRequest.builder()
                .targetId(targetResponse.getTargetId())
                .flatten(true)
                .build())
            .get();
        Protocol protocolSession = protocol.withSessionId(attachToTargetResponse.getSessionId().getValue());
        Page.NavigateResponse pageResponse = protocolSession.getPage()
            .navigate(Page.NavigateRequest.builder()
                .url("https://www.google.com")
                .build())
            .get();
        Thread.sleep(1_000); // wait for page rendering
        Page.CaptureScreenshotResponse screenshotResponse = protocolSession.getPage()
            .captureScreenshot(Page.CaptureScreenshotRequest.builder()
                .format(Page.CaptureScreenshotRequest.Format.PNG)
                .build())
            .get();
        byte[] bytes = Base64.getDecoder().decode(screenshotResponse.getData());
        Files.write(Path.of("screenshot.png"), bytes);
        protocol.close();
    }
}