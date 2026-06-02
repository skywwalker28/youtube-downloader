package org.example.youtube_downloader.client;


import org.example.youtube_downloader.dto.*;

public interface YtDlpClient {
    InfoResponse fetchVideoInfo(InfoRequest request);
    DownloadResponse downloadVideo(DownloadRequest request);
    FrameResponse extract39Frame(FrameRequest request);
}
