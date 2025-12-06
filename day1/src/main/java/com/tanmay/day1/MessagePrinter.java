package com.tanmay.day1;

import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {
    public void printMessage() {
        System.out.println("Hello, this is a notification message from NotificationService!");
    }
}
