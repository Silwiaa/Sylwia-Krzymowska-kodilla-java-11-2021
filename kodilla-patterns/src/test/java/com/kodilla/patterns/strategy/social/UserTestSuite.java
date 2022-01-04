package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.CorporateCustomer;
import com.kodilla.patterns.strategy.Customer;
import com.kodilla.patterns.strategy.IndividualCustomer;
import com.kodilla.patterns.strategy.IndividualYoungCustomer;
import com.kodilla.patterns.strategy.predictors.AggressivePredictor;
import com.kodilla.patterns.strategy.social.publishers.SnapchatPublisher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {
    @Test
    void testDefaultSharingStrategies() {
        //Given
        User joe = new Millenials("JoeX");
        User jane = new YGeneration("Jaxxa");
        User mike = new ZGeneration("Lolaxoxo");

        //When
        String joeSharesPost = joe.sharePost();
        System.out.println("Joe shared new post on: " + joeSharesPost + ", as: " + joe.getUserName());
        String janeSharesPost = jane.sharePost();
        System.out.println("Jane shared new post on: " + janeSharesPost + ", as: " + jane.getUserName());
        String mikeSharesPost = mike.sharePost();
        System.out.println("Mike shared new post on: " + mikeSharesPost + ", as: " + mike.getUserName());
        System.out.println();

        //Then
        assertEquals("Twitter", joeSharesPost);
        assertEquals("Facebook", janeSharesPost);
        assertEquals("Snapchat", mikeSharesPost);
    }

    @Test
    void testIndividualSharingStrategy() {
        //Given
        User joe = new Millenials("JoeX");

        //When
        String joeSharesPost = joe.sharePost();
        System.out.println("Joe shared new post on: " + joeSharesPost + ", as: " + joe.getUserName());
        joe.setSocialPublisher(new SnapchatPublisher());
        joeSharesPost = joe.sharePost();
        System.out.println("Now Steven shared his post on: " + joeSharesPost);

        //Then
        assertEquals("Snapchat", joeSharesPost);
    }
}
