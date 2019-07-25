package com.Bootcamp.TwitterBasic.Service.ServiceImpl;

import com.Bootcamp.TwitterBasic.Dao.Dao;
import com.Bootcamp.TwitterBasic.Dao.DaoFactory;
import com.Bootcamp.TwitterBasic.Service.Service;
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

    public List<Status> getTimeline(Twitter twitter) throws TwitterException
    {
        RetrieveTimeline retrieveTimeline = new RetrieveTimeline();
        return retrieveTimeline.getTimeLine(twitter);
    }
}
