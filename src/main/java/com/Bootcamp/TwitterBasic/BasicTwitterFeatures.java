package com.Bootcamp.TwitterBasic;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.util.List;
import java.util.Scanner;

public class BasicTwitterFeatures {
    public void postTweet(String text)
    {
        Twitter twitter = TwitterFactory.getSingleton();
        try
        {
            Status status = twitter.updateStatus(text);
        }catch(TwitterException TE)
        {
            System.out.println(TE);
        }
    }
    public void getMyTimeline()
    {
        Twitter twitter = TwitterFactory.getSingleton();
        try {
            List<Status> statuses = twitter.getHomeTimeline();
            System.out.println("The following a couple of tweets from my home timeline");
            for(Status status : statuses)
            {
                System.out.println(status.getUser().getName() + ":" + status.getText());
            }
        }catch(TwitterException TE)
        {
            System.out.println(TE);
        }

    }
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the status to be uploaded:");
        String text = input.nextLine();
        BasicTwitterFeatures features = new BasicTwitterFeatures();
        features.postTweet(text);
        features.getMyTimeline();
    }

}
