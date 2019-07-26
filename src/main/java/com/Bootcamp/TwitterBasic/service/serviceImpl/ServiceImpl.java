package com.Bootcamp.TwitterBasic.service.serviceImpl;

import com.Bootcamp.TwitterBasic.dao.Dao;
import com.Bootcamp.TwitterBasic.dao.DaoFactory;
import com.Bootcamp.TwitterBasic.models.StatusPojo;
import com.Bootcamp.TwitterBasic.service.Service;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.List;

public class ServiceImpl implements Service {
    public void postTweet(String name, String tweet, Twitter twitter) throws TwitterException
    {
        Dao dao = DaoFactory.getDao();
        PublishTweet publishTweet = new PublishTweet();
        String status = dao.getHandle(name) + tweet;
        publishTweet.createTweet(status, twitter);
    }

    public List<StatusPojo> getTimeline(Twitter twitter) throws TwitterException
    {
        RetrieveTimeline retrieveTimeline = new RetrieveTimeline();

        return retrieveTimeline.getTimeLine(twitter);
    }
}
