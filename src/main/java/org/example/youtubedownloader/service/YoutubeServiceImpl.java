package org.example.youtubedownloader.service;

import org.example.youtubedownloader.client.YtDlpClient;
import org.example.youtubedownloader.dto.YoutubeInfoRequest;
import org.example.youtubedownloader.dto.YoutubeInfoResponse;
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
