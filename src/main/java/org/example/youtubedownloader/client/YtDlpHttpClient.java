package org.example.youtubedownloader.client;

import org.example.youtubedownloader.dto.YoutubeInfoRequest;
import org.example.youtubedownloader.dto.YoutubeInfoResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class YtDlpHttpClient implements YtDlpClient {

    private final RestClient restClient;
    private final String infoPath;

    public YtDlpHttpClient(RestClient ytDlpRestClient, @Value("${ytdlp.paths.info:/info}") String infoPath) {
        this.restClient = ytDlpRestClient;
        this.infoPath = infoPath;
    }

    @Override
    public YoutubeInfoResponse fetchVideoInfo(YoutubeInfoRequest request) {
        return restClient.post()
                .uri(infoPath)
                .body(request)
                .retrieve()
                .body(YoutubeInfoResponse.class);
    }
}
