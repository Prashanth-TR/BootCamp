package com.Bootcamp.TwitterBasic.service;

import com.Bootcamp.TwitterBasic.models.StatusPojo;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.List;

public interface Service {
    void postTweet(String name1, String Tweet, Twitter twitter) throws TwitterException;
    List<StatusPojo> getTimeline(Twitter twitter) throws TwitterException;
}