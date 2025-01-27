import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.deripas.chrome.devtools.client.CDP;
import org.deripas.chrome.devtools.client.session.CDPSession;
import org.deripas.chrome.protocol.api.network.Network;
import org.deripas.chrome.protocol.api.network.Response;
import org.deripas.chrome.protocol.api.network.event.ResponseReceivedEvent;
import org.deripas.chrome.protocol.api.page.Page;
import org.deripas.chrome.protocol.api.runtime.Runtime;
import org.deripas.chrome.protocol.api.target.Target;
import org.deripas.chrome.protocol.api.target.event.AttachedToTargetEvent;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

@Slf4j
public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        CDPSession session = CDP.createDefault()
            .connect(URI.create("http://localhost:9222"))
            .get();
        session.subscribe(AttachedToTargetEvent.ID, event -> {
            log.info("Attached to target: {}", event);
        });
        session.subscribe(ResponseReceivedEvent.ID, event -> {
            Response response = event.getResponse();
            log.info("Status Code: {}", response.getStatus());
        });
        Target.CreateTargetResponse targetResponse = session.getTarget()
            .createTarget(Target.CreateTargetRequest.builder()
                .url("about:blank")
                .build())
            .get();
        Target.AttachToTargetResponse attachToTargetResponse = session.getTarget()
            .attachToTarget(Target.AttachToTargetRequest.builder()
                .targetId(targetResponse.getTargetId())
                .flatten(true)
                .build())
            .get();
        session.withSessionId(attachToTargetResponse.getSessionId());
        session.getNetwork().enable(Network.EnableRequest.builder().build()).get();

        Page.NavigateResponse pageResponse = session.getPage()
            .navigate(Page.NavigateRequest.builder()
                .url("https://www.google.com")
                .build())
            .get();
        Thread.sleep(1_000);
        Runtime.EvaluateResponse evaluateResponse = session.getRuntime()
            .evaluate(Runtime.EvaluateRequest.builder()
                .expression("document.documentElement.outerHTML")
                .build())
            .get();
        log.info("HTML: {}", evaluateResponse.getResult().getValue());

        Page.CaptureScreenshotResponse screenshotResponse = session.getPage()
            .captureScreenshot(Page.CaptureScreenshotRequest.builder()
                .format(Page.CaptureScreenshotRequest.Format.JPEG)
                .build())
            .get();
        byte[] bytes = Base64.getDecoder().decode(screenshotResponse.getData());
        Files.write(Path.of("screenshot.jpg"), bytes);
        session.close();
    }
}