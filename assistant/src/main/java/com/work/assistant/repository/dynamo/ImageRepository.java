package com.work.assistant.repository.dynamo;

import com.work.assistant.image.entity.Image;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface ImageRepository extends CrudRepository<Image, String> {
}
