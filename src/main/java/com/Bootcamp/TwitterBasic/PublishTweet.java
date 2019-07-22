package com.Bootcamp.TwitterBasic;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class PublishTweet {
    public String createTweet(String tweet,Twitter twitter) throws TwitterException {
        Status status = twitter.updateStatus(tweet);
        return status.getText();
    }
}
