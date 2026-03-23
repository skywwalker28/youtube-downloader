package org.example.youtube_downloader.service;

import org.example.youtube_downloader.client.YtDlpHttpClient;
import org.example.youtube_downloader.dto.FrameRequest;
import org.example.youtube_downloader.dto.FrameResponse;
import org.springframework.stereotype.Service;

@Service
public class FrameService {
    private final YtDlpHttpClient ytDlpHttpClient;

    public FrameService(YtDlpHttpClient ytDlpHttpClient) {
        this.ytDlpHttpClient = ytDlpHttpClient;
    }

    public FrameResponse get_39th_frame(String videoId, String formatId) {
        FrameRequest request = new FrameRequest(videoId, formatId);
        return ytDlpHttpClient.extract_39_frame(request);
    }
}
