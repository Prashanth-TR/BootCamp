package com.Bootcamp.TwitterBasic;

import com.Bootcamp.TwitterBasic.models.StatusPojo;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;


public class HbnBundle extends HibernateBundle<ApplicationConfiguration> {

    public HbnBundle() {
        super(StatusPojo.class);
    }

    @Override
    public PooledDataSourceFactory getDataSourceFactory(ApplicationConfiguration applicationConfiguration) {
        return applicationConfiguration.getDataSourceFactory();
    }
}
