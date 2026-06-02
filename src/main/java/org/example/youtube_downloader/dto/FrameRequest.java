package org.example.youtube_downloader.dto;

import jakarta.validation.constraints.NotBlank;

public record FrameRequest(
        @NotBlank(message = "video id must not be blank")
        String videoId,
        String formatId
) {}
