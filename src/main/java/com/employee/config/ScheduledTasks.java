package com.employee.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
//@EnableScheduling
public class ScheduledTasks {

	@Scheduled(fixedDelay = 10000)
	private void scheduledFixedDelayTask() {
		System.out.println("Hello Mittul!");
	}

}
