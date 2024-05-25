package com.work.assistant.image.model;

import lombok.Getter;

@Getter
public class ImageResponseDto {
    private Long id;

    private String name;

    private String url;

    public ImageResponseDto(Long id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }
}
