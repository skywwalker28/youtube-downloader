package org.example.youtube_downloader.service;

import org.example.youtube_downloader.dto.YoutubeDownloadRequest;
import org.example.youtube_downloader.dto.YoutubeInfoRequest;
import org.example.youtube_downloader.dto.YoutubeInfoResponse;

public interface YoutubeService {
    YoutubeInfoResponse getVideoInfo(YoutubeInfoRequest request);
    String downloadVideo(YoutubeDownloadRequest request);
}