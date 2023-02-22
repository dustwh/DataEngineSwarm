package com.luxbp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@SpringBootApplication
@EnableEurekaClient
public class MicroServiceCloudConfigClientBus3366Application {
    public static void main(String[] args) {
        SpringApplication.run(MicroServiceCloudConfigClientBus3366Application.class, args);
    }
}