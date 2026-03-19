package org.example.youtube_downloader.controller;

import jakarta.validation.Valid;
import org.example.youtube_downloader.dto.YoutubeInfoRequest;
import org.example.youtube_downloader.dto.YoutubeInfoResponse;
import org.example.youtube_downloader.service.YoutubeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/youtube")
public class YoutubeController {

    private final YoutubeService youtubeService;

    public YoutubeController(YoutubeService youtubeService) {
        this.youtubeService = youtubeService;
    }


    @PostMapping("/info")
    public YoutubeInfoResponse getInfo(@Valid @RequestBody YoutubeInfoRequest request) {
        return youtubeService.getVideoInfo(request);
    }
}