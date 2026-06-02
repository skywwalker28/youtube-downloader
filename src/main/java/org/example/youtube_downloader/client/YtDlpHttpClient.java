package org.example.youtube_downloader.client;

import org.example.youtube_downloader.dto.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class YtDlpHttpClient implements YtDlpClient {

    private final RestClient restClient;

    public YtDlpHttpClient(@Value("${ytdlp.base-url}") String baseUrl) {
        this.restClient = RestClient.builder().baseUrl(baseUrl).build();
    }

    @Override
    public InfoResponse fetchVideoInfo(InfoRequest request) {
        return restClient.post()
                .uri("/info")
                .body(request)
                .retrieve()
                .body(InfoResponse.class);
    }

    @Override
    public DownloadResponse downloadVideo(DownloadRequest request) {
        return restClient.post()
                .uri("/download")
                .body(request)
                .retrieve()
                .body(DownloadResponse.class);
    }

    @Override
    public FrameResponse extract39Frame(FrameRequest request) {
        return restClient.post()
                .uri("/frame39")
                .body(request)
                .retrieve()
                .body(FrameResponse.class);
    }
}