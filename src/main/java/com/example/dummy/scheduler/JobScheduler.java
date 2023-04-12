package com.example.dummy.scheduler;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
@EnableScheduling
public class JobScheduler {

    @Async
    @Scheduled(cron = "*/5 * * * * *")
    public void jobSchedulingAlgorithm() throws InterruptedException {

        long now = System.currentTimeMillis() / 1000;
        System.out.println("schedule tasks using cron jobs - " + now);
        Thread.sleep(5000);

    }
    
}
