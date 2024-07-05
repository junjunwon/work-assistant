package com.work.assistant.image.service;

import com.work.assistant.image.entity.Image;
import com.work.assistant.repository.dynamo.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageDAOService {

    private final ImageRepository imageRepository;


    public Image save(Image image) {
        return imageRepository.save(image);

    }

    public List<Image> findAll() {
        return (List<Image>) imageRepository.findAll();
    }

    public Image findById(String id) {
        return imageRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }
}
