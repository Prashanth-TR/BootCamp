package com.Bootcamp.TwitterBasic.service.serviceImpl;

import com.Bootcamp.TwitterBasic.dao.Dao;
import com.Bootcamp.TwitterBasic.dao.DaoFactory;
import com.Bootcamp.TwitterBasic.dao.StatusPojoDao;
import com.Bootcamp.TwitterBasic.models.StatusPojo;
import com.Bootcamp.TwitterBasic.service.Service;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class ServiceImpl implements Service {
    Date testTime = null;
    StatusPojoDao statusPojoDao;

    @Inject
    public ServiceImpl(StatusPojoDao statusPojoDao)
    {
        this.statusPojoDao = statusPojoDao;
    }

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

    public List<StatusPojo> getTimeLineDB(Twitter twitter) throws TwitterException
    {
        RetrieveTimeline retrieveTimeline = new RetrieveTimeline();

        List<StatusPojo> statusPojos = retrieveTimeline.getTimeLine(twitter);

        for(StatusPojo statusPojo : statusPojos)
        {
            statusPojoDao.create(statusPojo);
        }

        return statusPojoDao.findAll();
    }

    public Stream<StatusPojo> getFilteredTimeline(Twitter twitter) throws TwitterException
    {
        RetrieveTimeline retrieveTimeline = new RetrieveTimeline();
        List<StatusPojo> statusPojos = retrieveTimeline.getTimeLine(twitter);
        Stream<StatusPojo> filteredTweets = statusPojos.stream().filter(statusPojo -> statusPojo.getHandle().startsWith("A"));
        return filteredTweets;
    }

    public List<StatusPojo> getCachedTimeline(Twitter twitter, long cacheTimeLimit) throws TwitterException
    {
        Date currTime = new Date();
        if(testTime == null)
        {
            RetrieveTimeline retrieveTimeline = new RetrieveTimeline();
            List<StatusPojo> cache = retrieveTimeline.getTimeLine(twitter);
            Dao dao = DaoFactory.getDao();
            dao.setCache(cache);
            testTime = currTime;
            System.out.println("Accessing Twitter API");
            return cache;
        }
        long diffMilli = currTime.getTime() - testTime.getTime();
        long diffSec = TimeUnit.MILLISECONDS.toSeconds(diffMilli);

        if(diffSec > cacheTimeLimit)
        {
            RetrieveTimeline retrieveTimeline = new RetrieveTimeline();
            List<StatusPojo> cache = retrieveTimeline.getTimeLine(twitter);
            Dao dao = DaoFactory.getDao();
            dao.setCache(cache);
            testTime = currTime;
            System.out.println("Accessing Twitter API");
            return cache;
        }
        System.out.println("Accessing Cache");
        Dao dao = DaoFactory.getDao();
        return dao.getCache();
    }
}
