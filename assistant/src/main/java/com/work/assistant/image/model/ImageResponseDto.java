package com.work.assistant.image.model;

import com.work.assistant.image.entity.Image;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ImageResponseDto {
    private String id;

    private String name;

    private String url;

    private LocalDateTime expiryDate;

    public ImageResponseDto(String id, String name, String url, LocalDateTime expiryDate) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.expiryDate = expiryDate;
    }

    public static ImageResponseDto of(Image image) {
        return new ImageResponseDto(image.getId(), image.getName(), image.getUrl(), image.getExpiryDate());
    }
}
