package com.Bootcamp.TwitterBasic;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.vyarus.dropwizard.guice.GuiceBundle;
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
    public void initialize(Bootstrap<ApplicationConfiguration> bootstrap) {
        bootstrap.addBundle(GuiceBundle.builder()
                .enableAutoConfig(getClass().getPackage().getName())
                .modules(new InjectModule())
                .build());
       // bootstrap.addBundle(new AssetsBundle("/assets", "/pages", "index.html"));
    }

    @Override
    public void run(ApplicationConfiguration applicationConfiguration, Environment environment) throws Exception {


        //long cacheTime = applicationConfiguration.getCacheTime();

        //TwitterFactory tf = new TwitterFactory(cb.build());
//        final TwitterActions twitterActions = new TwitterActions();
//        environment.jersey().register(twitterActions);
    }
}
