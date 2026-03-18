package org.example.youtubedownloader.dto;

public record VideoFormatDto(
        String formatedId,
        String ext,
        String resolution,
        Integer fps,
        String vcodec,
        String acodec,
        Long filesize,
        boolean hasVideo,
        boolean hasAudio
) {}
