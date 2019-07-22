package com.Bootcamp.TwitterBasic;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import java.util.List;
public class RetrieveTimeline {
    /*public List<String> getTimeLine() throws TwitterException {
        Twitter twitter = getTwitterinstance();

        return twitter.getHomeTimeline().stream()
                .map(item -> item.getText())
                .collect(Collectors.toList());
    }*/
    //Twitter twitter = TwitterFactory.getSingleton();
    List<Status> statuses;

    public List<Status> getTimeLine(Twitter twitter) throws TwitterException
    {
        try {
            statuses = twitter.getHomeTimeline();
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        return statuses;
    }
}
