package com.Bootcamp.TwitterBasic;

import com.Bootcamp.TwitterBasic.models.StatusPojo;
import com.Bootcamp.TwitterBasic.service.Service;
import com.Bootcamp.TwitterBasic.service.ServiceFactory;
import com.codahale.metrics.annotation.Timed;


import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

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

    String consumerKey;
    String consumerSecret;
    String accessToken;
    String accessTokenSecret;

    long cacheTimeLimit;

    private static Logger logger = LogManager.getLogger(TwitterActions.class);

    public TwitterActions(Twitter twitter, long cacheTimeLimit)
    {
        this.twitter = twitter;
        this.cacheTimeLimit = cacheTimeLimit;
    }

    @GET
    @Path("/timeline")
    public Response timeline() throws Exception
    {
        logger.info("Executing GET request");
        try {
            Service service = ServiceFactory.getService();
            List<StatusPojo> twt = service.getTimeline(twitter);
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
    public Response tweet( String twt)
    {
        logger.debug("Executing POST request");
        try {
            Service service = ServiceFactory.getService();
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
        Service service = ServiceFactory.getService();
        Stream<StatusPojo> filteredTweets = service.getFilteredTimeline(twitter);
        return Response.ok().entity(filteredTweets).build();
    }

    @GET
    @Path("timeline/cache")
    public Response cache() throws TwitterException {
        Service service = ServiceFactory.getService();
        List<StatusPojo> cachedTimeline= service.getCachedTimeline(twitter, cacheTimeLimit);
        return Response.ok().entity(cachedTimeline).build();
    }
}
