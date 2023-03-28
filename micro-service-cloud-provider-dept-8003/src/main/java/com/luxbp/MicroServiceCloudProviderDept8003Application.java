package com.luxbp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@SpringBootApplication
@EnableEurekaClient // Spring cloud Eureka client, automatically registers this service in the Eureka Server registry
public class MicroServiceCloudProviderDept8003Application {
    public static void main(String[] args) {
        SpringApplication.run(MicroServiceCloudProviderDept8003Application.class, args);
    }
}