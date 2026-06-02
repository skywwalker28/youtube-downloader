package org.example.youtube_downloader.controller;

import jakarta.validation.Valid;
import org.example.youtube_downloader.client.YtDlpClient;
import org.example.youtube_downloader.dto.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/youtube")
public class YoutubeController {

    private final YtDlpClient ytDlpClient;

    public YoutubeController(YtDlpClient ytDlpClient) {
        this.ytDlpClient = ytDlpClient;
    }

    @PostMapping("/info")
    public InfoResponse getInfo(@RequestBody @Valid InfoRequest request) {
        return ytDlpClient.fetchVideoInfo(request);
    }

    @PostMapping("/download")
    public DownloadResponse download(@RequestBody @Valid DownloadRequest request) {
        return ytDlpClient.downloadVideo(request);
    }

    @PostMapping("/frame39")
    public FrameResponse getFrame39(@RequestBody @Valid FrameRequest request) {
        return ytDlpClient.extract39Frame(new FrameRequest(request.videoId(), request.formatId()));
    }
}