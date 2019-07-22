package com.Bootcamp.TwitterBasic;

import com.codahale.metrics.annotation.Timed;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/twitter-api/1.0")
@Produces(MediaType.APPLICATION_JSON)
public class TwitterActions {
    Twitter twitter;
    String consumerKey;
    String consumerSecret;
    String accessToken;
    String accessTokenSecret;

    public TwitterActions(Twitter twitter) {
        this.twitter = twitter;
    }
    ////////
    @GET
    @Path("/timeline")
    public Response timeline() throws Exception
    {
        try {
            RetrieveTimeline retrieveTimeline = new RetrieveTimeline();
            List<Status> twt = retrieveTimeline.getTimeLine(twitter);
            return Response.ok().entity(twt).build();
        }catch(TwitterException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
    @POST
    @Path("/tweet")
    @Timed
    public Response tweet(String twt)
    {
        try{
            PublishTweet publishTweet = new PublishTweet();
            publishTweet.createTweet(twt,twitter);
            return Response.ok().build();
        } catch (TwitterException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
    /*public void tweet()
    {
        try
        {
            twitter.updateStatus(txt);
        }catch(TwitterException E)
        {
            final String message = E.getMessage();
            System.out.println(message);
        }
    }*/

}
