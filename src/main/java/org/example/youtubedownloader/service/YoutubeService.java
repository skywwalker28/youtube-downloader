package org.example.youtubedownloader.service;

import org.example.youtubedownloader.dto.YoutubeInfoRequest;
import org.example.youtubedownloader.dto.YoutubeInfoResponse;

public interface YoutubeService {
    YoutubeInfoResponse getVideoInfo(YoutubeInfoRequest request);
}
