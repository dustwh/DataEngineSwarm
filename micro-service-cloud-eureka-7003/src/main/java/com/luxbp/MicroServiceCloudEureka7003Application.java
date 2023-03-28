package com.luxbp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@SpringBootApplication
@EnableEurekaServer //Open the Eureka server and accept the registration of other microservices
public class MicroServiceCloudEureka7003Application {
    public static void main(String[] args) {
        SpringApplication.run(MicroServiceCloudEureka7003Application.class, args);
    }
}