package org.example.youtube_downloader.client;


import org.example.youtube_downloader.dto.*;

public interface YtDlpClient {
    YoutubeInfoResponse fetchVideoInfo(YoutubeInfoRequest request);
    String downloadVideo(YoutubeDownloadRequest request);
    FrameResponse extract39Frame(FrameRequest request);
}
