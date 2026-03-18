package org.example.youtubedownloader.controller;

import jakarta.validation.Valid;
import org.example.youtubedownloader.dto.YoutubeInfoRequest;
import org.example.youtubedownloader.dto.YoutubeInfoResponse;
import org.example.youtubedownloader.service.YoutubeService;
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
