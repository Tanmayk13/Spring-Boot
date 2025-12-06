package com.tanmay.day1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Day1Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Day1Application.class, args);
        NotificationService notificationService = context.getBean(NotificationService.class);
        notificationService.sendNotification();
	}
}
