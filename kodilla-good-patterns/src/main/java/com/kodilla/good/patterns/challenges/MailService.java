package com.kodilla.good.patterns.challenges;

public class MailService implements InformationService {
    @Override
    public void inform(User user) {
        System.out.println("Order message send. Message text:");
        System.out.println("\"Hi, " + user.getName());
        System.out.println("Thank you for visit us. Your order is ready to packing.\"");
    }
}
