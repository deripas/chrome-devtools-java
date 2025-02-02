import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.deripas.chrome.devtools.client.CDP;
import org.deripas.chrome.devtools.client.session.CDPSession;
import org.deripas.chrome.protocol.api.page.Page;
import org.deripas.chrome.protocol.api.target.Target;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

@Slf4j
public class ExampleCaptureScreenshot {

    @SneakyThrows
    public static void main(String[] args) {
        CDPSession session = CDP.createDefault()
            .connect(URI.create("http://localhost:9222"))
            .get();
        Target.CreateBrowserContextResponse browserContextResponse = session.getTarget()
            .createBrowserContext(Target.CreateBrowserContextRequest
                .builder()
                .disposeOnDetach(true)
                .build())
            .get();
        Target.CreateTargetResponse targetResponse = session.getTarget()
            .createTarget(Target.CreateTargetRequest.builder()
                .url("about:blank")
                .browserContextId(browserContextResponse.getBrowserContextId())
                .build())
            .get();
        Target.AttachToTargetResponse attachToTargetResponse = session.getTarget()
            .attachToTarget(Target.AttachToTargetRequest.builder()
                .targetId(targetResponse.getTargetId())
                .flatten(true)
                .build())
            .get();
        CDPSession withSessionId = session.withSessionId(attachToTargetResponse.getSessionId());
        Page.NavigateResponse pageResponse = withSessionId.getPage()
            .navigate(Page.NavigateRequest.builder()
                .url("https://www.google.com")
                .build())
            .get();
        Thread.sleep(1_000); // wait for page rendering
        Page.CaptureScreenshotResponse screenshotResponse = withSessionId.getPage()
            .captureScreenshot(Page.CaptureScreenshotRequest.builder()
                .format(Page.CaptureScreenshotRequest.Format.PNG)
                .build())
            .get();
        byte[] bytes = Base64.getDecoder().decode(screenshotResponse.getData());
        Files.write(Path.of("screenshot.png"), bytes);
        session.close();
    }
}