package com.luxbp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class DataEngineScheduledJobs8082Application {
    public static void main(String[] args) {
        SpringApplication.run(DataEngineScheduledJobs8082Application.class, args);
    }

}
