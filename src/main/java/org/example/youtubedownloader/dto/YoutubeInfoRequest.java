package org.example.youtubedownloader.dto;

import jakarta.validation.constraints.NotBlank;

public record YoutubeInfoRequest(
        @NotBlank(message = "url must not be blank")
        String url
) {}
