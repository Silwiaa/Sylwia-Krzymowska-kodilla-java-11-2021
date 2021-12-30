package com.kodilla.good.patterns.food2Door;

public class MailService implements InformationService {
    @Override
    public void inform(String provider) {
        System.out.println("Order message send. Message text:");
        System.out.println("\"Hi, " + provider + ",");
        System.out.println("New order has been completed from your offer. Thank you for being part of our team." + "\n");
    }
}
