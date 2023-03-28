package com.luxbp.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ConfigBean {
    /**
     * OpenFeign log enhancement
     * Configure what OpenFeign logs
     */
    @Bean
    Logger.Level feginLoggerLevel() {
        return Logger.Level.FULL;
    }
}
