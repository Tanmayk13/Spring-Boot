package com.tanmay.day1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private MessagePrinter printer1;
    private MessagePrinter printer2;

    NotificationService(MessagePrinter printer1) {
        this.printer1 = printer1;
        System.out.println("Single parameter constructor called");
    }

    @Autowired
    NotificationService(MessagePrinter printer1, MessagePrinter printer2) {
        this.printer1 = printer1;
        this.printer2 = printer2;
        System.out.println("Two parameter constructor called");
    }

    public void sendNotification() {
        printer1.printMessage();
        printer2.printMessage();
    }
}
