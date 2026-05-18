package org.example.youtube_downloader.service;

import org.example.youtube_downloader.client.YtDlpClient;
import org.example.youtube_downloader.dto.FrameRequest;
import org.example.youtube_downloader.dto.FrameResponse;
import org.springframework.stereotype.Service;

@Service
public class FrameService {
    private final YtDlpClient ytDlpClient;

    public FrameService(YtDlpClient ytDlpClient) {
        this.ytDlpClient = ytDlpClient;
    }

    public FrameResponse get_39th_frame(String videoId, String formatId) {
        FrameRequest request = new FrameRequest(videoId, formatId);
        return ytDlpClient.extract39Frame(request);
    }
}