package com.work.assistant;

import com.work.assistant.common.properties.AwsProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AwsProperties.class)
public class WorkAssistantApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkAssistantApplication.class, args);
	}

}
