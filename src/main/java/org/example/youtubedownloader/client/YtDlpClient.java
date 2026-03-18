package org.example.youtubedownloader.client;

import org.example.youtubedownloader.dto.YoutubeInfoRequest;
import org.example.youtubedownloader.dto.YoutubeInfoResponse;
import org.springframework.stereotype.Component;

@Component
public interface YtDlpClient {
    YoutubeInfoResponse fetchVideoInfo(YoutubeInfoRequest request);
}
