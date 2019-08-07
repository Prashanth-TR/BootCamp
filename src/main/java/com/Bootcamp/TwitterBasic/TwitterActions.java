package com.Bootcamp.TwitterBasic;

import com.Bootcamp.TwitterBasic.models.StatusPojo;
import com.Bootcamp.TwitterBasic.service.Service;
//import com.Bootcamp.TwitterBasic.service.ServiceFactory;
import com.codahale.metrics.annotation.Timed;


import io.dropwizard.hibernate.UnitOfWork;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


@Path("/twitter-api/1.0")
@Produces(MediaType.APPLICATION_JSON)
public class TwitterActions {

    Twitter twitter;

    private static Logger logger = LogManager.getLogger(TwitterActions.class);
    long cacheTimeLimit;

    @Inject
    public Service service;


    @Inject
    public TwitterActions(
            @Named("consumerKey") String consumerKey,
            @Named("consumerSecret") String consumerSecret,
            @Named("accessToken") String accessToken,
            @Named("accessTokenSecret") String accessTokenSecret,
            @Named("cacheTimeLimit") long cacheTimeLimit
    )
    {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey(consumerKey);
        cb.setOAuthConsumerSecret(consumerSecret);
        cb.setOAuthAccessToken(accessToken);
        cb.setOAuthAccessTokenSecret(accessTokenSecret);

        TwitterFactory twitterFactory = new TwitterFactory(cb.build());
        this.twitter = twitterFactory.getInstance();
        this.cacheTimeLimit = cacheTimeLimit;
    }

    @GET
    @Path("/timeline")
    @UnitOfWork
    public Response timeline() throws Exception
    {
        logger.info("Executing GET request");
        try {
            //Service service = ServiceFactory.getService();
            List<StatusPojo> twt = service.getTimeLineDB(twitter);
           // logger.debug("{}",service);
            return Response.ok().entity(twt).build();
        }catch(TwitterException e) {
            logger.error(e.getErrorMessage(), e);
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("/tweet")
    @Timed
    @UnitOfWork
    public Response tweet( String twt)
    {
        logger.debug("Executing POST request");
        try {
            //Service service = ServiceFactory.getService();
            service.postTweet("Prashanth ", twt, twitter);
            return Response.ok().build();
        }catch (TwitterException e)
        {
            logger.error(e.getErrorMessage(), e);
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/timeline/filter")
    public Response filter() throws TwitterException {
        //Service service = ServiceFactory.getService();
        Stream<StatusPojo> filteredTweets = service.getFilteredTimeline(twitter);
        return Response.ok().entity(filteredTweets).build();
    }

    @GET
    @Path("timeline/cache")
    public Response cache() throws TwitterException {
        //Service service = ServiceFactory.getService();
        List<StatusPojo> cachedTimeline= service.getCachedTimeline(twitter, cacheTimeLimit);
        return Response.ok().entity(cachedTimeline).build();
    }
}
