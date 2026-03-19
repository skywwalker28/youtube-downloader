package org.example.youtube_downloader.client;


import org.example.youtube_downloader.dto.YoutubeInfoRequest;
import org.example.youtube_downloader.dto.YoutubeInfoResponse;
import org.springframework.stereotype.Component;

@Component
public interface YtDlpClient {
    YoutubeInfoResponse fetchVideoInfo(YoutubeInfoRequest request);
}