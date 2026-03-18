package org.example.youtubedownloader.controller;

import org.example.youtubedownloader.dto.VideoFormatDto;
import org.example.youtubedownloader.dto.YoutubeInfoRequest;
import org.example.youtubedownloader.dto.YoutubeInfoResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mock-ytdlp")
public class MockYtDlpController {

    @PostMapping("/info")
    public YoutubeInfoResponse info(@RequestBody YoutubeInfoRequest request) {
        return new YoutubeInfoResponse(
                "video123",
                "Mock video for " + request.url(),
                321L,
                "Mock uploader",
                "https://example.com/thumb.jpg",
                List.of(
                        new VideoFormatDto(
                                "18",
                                "mp4",
                                "640x360",
                                30,
                                "avc1",
                                "mp4a",
                                10_000_000L,
                                true,
                                true
                        ),

                        new VideoFormatDto(
                                "137",
                                "mp4",
                                "1920x1080",
                                30,
                                "avc1",
                                "none",
                                40_000_000L,
                                true,
                                false
                        )
                )

        );
    }
}
