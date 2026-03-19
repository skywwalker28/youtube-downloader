package org.example.youtube_downloader.service;

import org.example.youtube_downloader.client.YtDlpClient;
import org.example.youtube_downloader.dto.YoutubeInfoRequest;
import org.example.youtube_downloader.dto.YoutubeInfoResponse;
import org.springframework.stereotype.Service;

@Service
public class YoutubeServiceImpl implements YoutubeService {
    private final YtDlpClient ytDlpClient;

    public YoutubeServiceImpl(YtDlpClient ytDlpClient) {
        this.ytDlpClient = ytDlpClient;
    }

    @Override
    public YoutubeInfoResponse getVideoInfo(YoutubeInfoRequest request) {
        return ytDlpClient.fetchVideoInfo(request);
    }
}
