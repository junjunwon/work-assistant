package com.work.assistant.image.service;

import com.work.assistant.image.entity.Image;
import com.work.assistant.image.model.ImageResponseDto;
import com.work.assistant.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageDaoService {

    private final ImageRepository imageRepository;

    public Image save(Image image) {
        return imageRepository.save(image);

    }

    public List<Image> findAll() {
        return imageRepository.findAll();
    }
}
