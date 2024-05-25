package com.work.assistant.image.service;

import com.work.assistant.image.entity.Image;
import com.work.assistant.image.model.ImageResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageDaoService imageDaoService;

    public ImageResponseDto saveImage(MultipartFile file) {
        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path path = Paths.get("images/" + fileName);

        try {
            Files.copy(file.getInputStream(), path);
        } catch (IOException e) {
            e.printStackTrace();
        }


        Image image = new Image(fileName, "/uploads/" + fileName);

        imageDaoService.save(image);

        return new ImageResponseDto(image.getId(), image.getName(), image.getUrl());
    }

    public List<Image> getAllImages() {
        return imageDaoService.findAll();
    }
}
