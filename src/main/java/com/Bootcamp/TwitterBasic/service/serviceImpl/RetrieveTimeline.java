package com.Bootcamp.TwitterBasic.service.serviceImpl;

import com.Bootcamp.TwitterBasic.models.StatusPojo;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.ArrayList;
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
    List<StatusPojo> statusPojos = new ArrayList<>();
    public List<StatusPojo> getTimeLine(Twitter twitter) throws TwitterException
    {
        try {
            statuses = twitter.getHomeTimeline();
            for(Status status : statuses) {

                StatusPojo statusPojo = new StatusPojo();
                statusPojo.setName(status.getUser().getName());
                statusPojo.setHandle(status.getUser().getScreenName());
                statusPojo.setMessage(status.getText());
                statusPojo.setCreatedAt(String.valueOf(status.getCreatedAt()));
                statusPojo.setProfileImageUrl(status.getUser().getProfileImageURL());
                System.out.println(statusPojo);
                statusPojos.add(statusPojo);
            }
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        return statusPojos;
    }
}
