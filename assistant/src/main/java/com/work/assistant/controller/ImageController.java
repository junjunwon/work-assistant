package com.work.assistant.controller;

import com.work.assistant.image.model.ImageResponseDto;
import com.work.assistant.image.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/image")
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity<ImageResponseDto> uploadImage(@RequestParam("file") MultipartFile file) {
        ImageResponseDto imageResponseDto = imageService.saveImage(file);
        return ResponseEntity.ok(imageResponseDto);
    }
}
