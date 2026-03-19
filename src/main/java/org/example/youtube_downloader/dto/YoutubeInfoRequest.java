package org.example.youtube_downloader.dto;

import jakarta.validation.constraints.NotBlank;

public record YoutubeInfoRequest(
        @NotBlank(message = "url must not be blank")
        String url
) {}