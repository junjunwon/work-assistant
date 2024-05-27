package com.work.assistant.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.work.assistant.common.aws.properties.AwsProperties;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.work.assistant.repository")
public class DynamoDBConfig {

//    @Value("${aws.accessKeyId}")
//    private String amazonAWSAccessKey;
//
//    @Value("${aws.secretKey}")
//    private String amazonAWSSecretKey;
//
//    @Value("${aws.region}")
//    private String awsRegion;

    private final AwsProperties awsProperties;

    public DynamoDBConfig(AwsProperties awsProperties) {
        this.awsProperties = awsProperties;
    }

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(awsProperties.getAccessKeyId(), awsProperties.getSecretKey());

        return AmazonDynamoDBClientBuilder.standard()
                .withRegion(Regions.fromName(awsProperties.getRegion()))
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .build();
    }

    @Bean
    public AmazonS3 amazonS3() {
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(awsProperties.getAccessKeyId(), awsProperties.getSecretKey());

        return AmazonS3ClientBuilder.standard()
                .withRegion(Regions.fromName(awsProperties.getRegion()))
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .build();
    }
}

