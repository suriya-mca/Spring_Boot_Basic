package com.example.dummy.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
// import org.springframework.stereotype.Component;

// @Component
@EnableAsync
@EnableScheduling
public class JobScheduler {

    Logger logger = LoggerFactory.getLogger(JobScheduler.class);

    @Async
    @Scheduled(cron = "*/5 * * * * *")
    public void jobSchedulingAlgorithm() throws InterruptedException {

        long now = System.currentTimeMillis() / 1000;
        logger.info("schedule tasks using cron jobs - " + now);
        Thread.sleep(5000);

    }
    
}
