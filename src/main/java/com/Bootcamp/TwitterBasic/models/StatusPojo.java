package com.Bootcamp.TwitterBasic.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "tweet_data")
public class StatusPojo {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @NotNull
    private long id;

    @Column(name = "message")
    private String message;

    @Column(name = "name")
    private String name;

    @Column(name = "handle")
    private String handle;

    @Column(name = "profile_image_url")
    private String profileImageUrl;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "tweet_url")
    private String tweetUrl;

    @JsonProperty
    public void setId(long id)
    {
        this.id = id;
    }

    @JsonProperty
    public long getId()
    {
        return id;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    @JsonProperty
    public String getMessage()
    {
        return message;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @JsonProperty
    public String getName()
    {
        return name;
    }

    public void setHandle(String handle)
    {
        this.handle = handle;
    }

    @JsonProperty
    public String getHandle()
    {
        return handle;
    }

    public void setProfileImageUrl(String profileImageUrl)
    {
        this.profileImageUrl = profileImageUrl;
    }

    @JsonProperty
    public String getProfileImageUrl()
    {
        return profileImageUrl;
    }

    public void setCreatedAt(String createdAt)
    {
        this.createdAt = createdAt;
    }

    @JsonProperty
    public String getCreatedAt()
    {
        return createdAt;
    }

    public void setTweetUrl(String tweetUrl){ this.tweetUrl = tweetUrl;}

    @JsonProperty
    public String getTweetUrl(){ return tweetUrl;}
}
