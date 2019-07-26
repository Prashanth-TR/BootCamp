package com.Bootcamp.TwitterBasic;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;


public class MainApplication extends Application<ApplicationConfiguration> {
    public static void main(String[] args) throws Exception{
        final Logger logger = LogManager.getLogger(MainApplication.class);
        logger.info("Executing Main Function");
        new MainApplication().run(args);
    }
    @Override
    public void run(ApplicationConfiguration applicationConfiguration, Environment environment) throws Exception {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey(applicationConfiguration.getConsumerKey());
        cb.setOAuthConsumerSecret(applicationConfiguration.getConsumerSecret());
        cb.setOAuthAccessToken(applicationConfiguration.getAccessToken());
        cb.setOAuthAccessTokenSecret(applicationConfiguration.getAccessTokenSecret());
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        final TwitterActions twitterActions = new TwitterActions(twitter);
        environment.jersey().register(twitterActions);
    }
}
