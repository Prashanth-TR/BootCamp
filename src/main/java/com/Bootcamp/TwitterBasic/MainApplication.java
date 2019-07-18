package com.Bootcamp.TwitterBasic;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;


public class MainApplication extends Application<ApplicationConfiguration> {
    public static void main(String[] args) throws Exception{
        new MainApplication().run(args);
    }
    @Override
    public void run(ApplicationConfiguration applicationConfiguration, Environment environment) throws Exception {
        final TwitterActions publishTweet = new TwitterActions(
                applicationConfiguration.getConsumerKey(),
                applicationConfiguration.getConsumerSecret(),
                applicationConfiguration.getAccessToken(),
                applicationConfiguration.getAccessTokenSecret()
        );
        environment.jersey().register(publishTweet);
    }
}
