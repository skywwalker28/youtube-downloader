package org.example.youtube_downloader.dto;

import java.util.List;

public record YoutubeInfoResponse(
        String id,
        String title,
        Long durationSec,
        String uploader,
        String thumbnail,
        List<VideoFormatDto> formats
) {}
