package com.Bootcamp.TwitterBasic;

import com.Bootcamp.TwitterBasic.dao.StatusPojoDao;
import com.Bootcamp.TwitterBasic.dao.daoImpl.StatusPojoDaoImpl;
import com.Bootcamp.TwitterBasic.service.Service;
import com.Bootcamp.TwitterBasic.service.serviceImpl.ServiceImpl;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.vyarus.dropwizard.guice.module.support.DropwizardAwareModule;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class InjectModule extends DropwizardAwareModule<ApplicationConfiguration> {

    private HbnBundle hbnBundle;

    public InjectModule(HbnBundle hbnBundle) {
        this.hbnBundle = hbnBundle;
    }


    @Override
    protected void configure()
    {
        bind(StatusPojoDao.class).to(StatusPojoDaoImpl.class);
        bind(SessionFactory.class).toInstance(hbnBundle.getSessionFactory());
        bind(String.class).annotatedWith(Names.named("consumerKey")).toInstance(configuration().getConsumerKey());
        bind(String.class).annotatedWith(Names.named("consumerSecret")).toInstance(configuration().getConsumerSecret());
        bind(String.class).annotatedWith(Names.named("accessToken")).toInstance(configuration().getAccessToken());
        bind(String.class).annotatedWith(Names.named("accessTokenSecret")).toInstance(configuration().getAccessTokenSecret());
        bind(long.class).annotatedWith(Names.named("cacheTimeLimit")).toInstance(configuration().getCacheTime());
        bind(Service.class).to(ServiceImpl.class);
    }
}
