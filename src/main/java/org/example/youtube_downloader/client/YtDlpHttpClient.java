package org.example.youtube_downloader.client;

import org.example.youtube_downloader.dto.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class YtDlpHttpClient implements YtDlpClient {

    private final RestClient restClient;
    private final String infoPath;

    public YtDlpHttpClient(
            @Value("${ytdlp.base-url}") String baseUrl,
            @Value("${ytdlp.paths.info}") String infoPath
    ) {
        this.restClient = RestClient.builder().baseUrl(baseUrl).build();
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

    @Override
    public String downloadVideo(YoutubeDownloadRequest request) {
        return restClient.post()
                .uri("/download")
                .body(request)
                .retrieve()
                .body(String.class);
    }

    public FrameResponse extract_39_frame(FrameRequest request) {
        return restClient.post()
                .uri("/frame39")
                .body(request)
                .retrieve()
                .body(FrameResponse.class);
    }
}