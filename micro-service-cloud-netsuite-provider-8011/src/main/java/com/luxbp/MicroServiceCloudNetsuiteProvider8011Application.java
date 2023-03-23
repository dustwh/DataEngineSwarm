package com.luxbp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroServiceCloudNetsuiteProvider8011Application {
    public static void main(String[] args) {
        SpringApplication.run(MicroServiceCloudNetsuiteProvider8011Application.class, args);
    }
}
