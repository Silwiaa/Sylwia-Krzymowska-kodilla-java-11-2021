package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.FacebookPublisher;
import com.kodilla.patterns.strategy.social.publishers.TwitterPublisher;

public final class YGeneration extends User {
    public YGeneration(String userName) {
        super(userName);
        this.socialPublisher = new FacebookPublisher();
    }
}
