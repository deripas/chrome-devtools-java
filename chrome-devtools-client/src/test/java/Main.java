import lombok.SneakyThrows;
import org.deripas.chrome.devtools.client.CDP;
import org.deripas.chrome.protocol.api.Protocol;
import org.deripas.chrome.protocol.api.page.Page;
import org.deripas.chrome.protocol.api.target.Target;

import java.net.URI;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        Protocol protocol = CDP.create()
            .http(URI.create("http://localhost:9222"))
            .get();
        System.out.println("Hello, World!");

        protocol.getTarget()
            .createTarget(Target.CreateTargetRequest.builder()
                .url("about:blank")
                .build());
        protocol.getPage()
            .enable();
        protocol.getPage()
            .navigate(Page.NavigateRequest.builder()
                .url("https://www.google.com")
                .build());

        Thread.sleep(5_000);
    }
}