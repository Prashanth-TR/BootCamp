package com.Bootcamp.TwitterBasic;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

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


}