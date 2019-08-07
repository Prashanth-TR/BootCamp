package com.Bootcamp.TwitterBasic;

import com.mysql.cj.jdbc.MysqlDataSourceFactory;
import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;
import io.dropwizard.db.DataSourceFactory;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;


public class ApplicationConfiguration extends Configuration {
    @NotEmpty
    private String consumerKey;
    @NotEmpty
    private String consumerSecret;
    @NotEmpty
    private String accessToken;
    @NotEmpty
    private String accessTokenSecret;
    @NotNull
    private long cacheTime;

    @Valid
    @NotNull
    private DataSourceFactory dataSourceFactory = new DataSourceFactory();

    @JsonProperty
    public String getConsumerKey() {
        return consumerKey;
    }

    @JsonProperty
    public void setConsumerKey(String consumerKey){ this.consumerKey = consumerKey;}

    @JsonProperty
    public String getConsumerSecret() {
        return consumerSecret;
    }

    @JsonProperty
    public void setConsumerSecret(String consumerSecret){ this.consumerSecret = consumerSecret;}

    @JsonProperty
    public String getAccessToken() {
        return accessToken;
    }

    @JsonProperty
    public void setAccessToken(String accessToken){ this.accessToken = accessToken;}

    @JsonProperty
    public String getAccessTokenSecret() {
        return accessTokenSecret;
    }

    @JsonProperty
    public void setAccessTokenSecret(String accessTokenSecret){ this.accessTokenSecret = accessTokenSecret;}

    @JsonProperty
    public long getCacheTime() { return cacheTime;}

    @JsonProperty
    public void setCacheTime(long cacheTime){this.cacheTime = cacheTime;}

    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory() {
        return dataSourceFactory;
    }

}