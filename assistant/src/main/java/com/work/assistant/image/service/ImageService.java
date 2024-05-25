package com.work.assistant.image.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.work.assistant.common.properties.AwsProperties;
import com.work.assistant.image.entity.Image;
import com.work.assistant.image.model.ImageResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageDaoService imageDaoService;
    private final AmazonS3 s3Client;
    private AwsProperties awsProperties;

    public ImageResponseDto saveImage(MultipartFile file) {
        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path tempFile = null;

        try {
            tempFile = Files.createTempFile(UUID.randomUUID().toString(), file.getOriginalFilename());
            Files.write(tempFile, file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        s3Client.putObject(new PutObjectRequest(awsProperties.getS3BucketName(), fileName, tempFile.toFile()));

        URL fileUrl = s3Client.getUrl(awsProperties.getS3BucketName(), fileName);

        Image image = new Image(UUID.randomUUID().toString(), fileName,
                fileUrl.toString(), LocalDateTime.now().plus(7, ChronoUnit.DAYS));

        try {
            Files.delete(tempFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        imageDaoService.save(image);
        return new ImageResponseDto(image.getId(), image.getName(), image.getUrl(), image.getExpiryDate());
    }

    public List<ImageResponseDto> getAllImages() {
        List<Image> imageList = imageDaoService.findAll();

        return imageList.stream().map(ImageResponseDto::of).toList();
    }

    public ImageResponseDto getImageById(String id) {
        Image image = imageDaoService.findById(id);
        if (image.getExpiryDate().isBefore(LocalDateTime.now())) {
            throw new RuntimeException();
        }
        return new ImageResponseDto(image.getId(), image.getName(), image.getUrl(), image.getExpiryDate());
    }
}
