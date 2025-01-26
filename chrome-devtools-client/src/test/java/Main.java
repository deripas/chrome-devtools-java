import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.deripas.chrome.devtools.client.CDP;
import org.deripas.chrome.devtools.client.session.CDPSession;
import org.deripas.chrome.protocol.api.page.Page;
import org.deripas.chrome.protocol.api.runtime.Runtime;
import org.deripas.chrome.protocol.api.target.Target;

import java.net.URI;

@Slf4j
public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        CDPSession session = CDP.createDefault()
            .connect(URI.create("http://localhost:9222"))
            .get();

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

        session.getPage()
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
        session.close();
    }
}