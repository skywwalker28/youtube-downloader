package org.example.youtube_downloader.dto;

public record YoutubeDownloadRequest(
        String url,
        String formatId
) {}
