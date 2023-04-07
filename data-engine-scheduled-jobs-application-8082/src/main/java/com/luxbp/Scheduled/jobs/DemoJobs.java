package com.luxbp.Scheduled.jobs;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class DemoJobs {
    private Double price;

    public Double getProductPrice() {
        return price;

    }

    @Scheduled(fixedDelay = 2000)
    public void runAt2secondsAfterPreviousJobCompleted() throws InterruptedException {
        System.out.println("computing price at "+ LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));
        Thread.sleep(4000);
    }

    @Scheduled(fixedRate = 3000)
    @Async
    public void runEvery3secondsNoMatterPreviousJobFinishOrNot() {
        System.out.println("    fired every 3 seconds no matter whether I'm finished or not.\n    Can run in Async mode, need to add '@EnableAsync' tag on SchedulerConfig");
    }
}
