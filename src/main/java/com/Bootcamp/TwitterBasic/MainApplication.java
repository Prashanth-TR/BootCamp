package com.Bootcamp.TwitterBasic;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;


public class MainApplication extends Application<ApplicationConfiguration> {
    public static void main(String[] args) throws Exception{
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
