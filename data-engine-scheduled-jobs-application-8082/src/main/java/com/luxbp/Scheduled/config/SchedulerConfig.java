package com.luxbp.Scheduled.config;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

//As a best practice we should add EnableScheduling to a dedicated class under a package that contains the code for our scheduled jobs
//The scheduling will now only be activated when we load the SchedulerConfig class into the application, providing better modularization.
@Configuration
@EnableScheduling
//@EnableAsync
@ConditionalOnProperty(name = "scheduler.enabled", matchIfMissing = true)
public class SchedulerConfig {

}