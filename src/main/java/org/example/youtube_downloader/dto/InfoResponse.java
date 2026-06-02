package org.example.youtube_downloader.dto;

import java.util.List;

public record InfoResponse(
        String id,
        String title,
        Long duration,
        String uploader,
        String thumbnail,
        List<VideoFormatDto> formats
) {}