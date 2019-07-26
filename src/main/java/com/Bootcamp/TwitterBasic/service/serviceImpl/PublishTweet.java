package com.Bootcamp.TwitterBasic.service.serviceImpl;

import com.Bootcamp.TwitterBasic.models.StatusPojo;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class PublishTweet {
    public String createTweet(String tweet, Twitter twitter) throws TwitterException {
        Status status = twitter.updateStatus(tweet);
        return status.getText();
    }
}
