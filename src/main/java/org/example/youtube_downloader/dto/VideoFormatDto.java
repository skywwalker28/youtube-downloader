package org.example.youtube_downloader.dto;

public record VideoFormatDto(
        String formatId,
        String ext,
        String resolution,
        Integer fps,
        String vcodec,
        String acodec,
        Long filesize,
        Boolean hasVideo,
        Boolean hasAudio
) {}