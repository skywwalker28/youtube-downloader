package org.example.youtube_downloader.controller;

import jakarta.validation.Valid;
import org.example.youtube_downloader.dto.*;
import org.example.youtube_downloader.service.FrameService;
import org.example.youtube_downloader.service.YoutubeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/youtube")
public class YoutubeController {

    private final YoutubeService youtubeService;
    private final FrameService frameService;

    public YoutubeController(YoutubeService youtubeService, FrameService frameService) {
        this.youtubeService = youtubeService;
        this.frameService = frameService;
    }


    @PostMapping("/info")
    public YoutubeInfoResponse getInfo(@Valid @RequestBody YoutubeInfoRequest request) {
        return youtubeService.getVideoInfo(request);
    }

    @PostMapping("/download")
    public String download(@RequestBody YoutubeDownloadRequest request) {
        return youtubeService.downloadVideo(request);
    }

    @PostMapping("/frame39")
    public FrameResponse getFrame39(@RequestBody FrameRequest request) {
        return frameService.get_39th_frame(request.videoId(), request.formatId());
    }
}