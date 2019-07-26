package com.Bootcamp.TwitterBasic.models;

import java.util.Date;

public class StatusPojo {
    private String message;
    private String name;
    private String handle;
    private String profileImageUrl;
    private String createdAt;

    public void setMessage(String message)
    {
        this.message = message;
    }
    public String getMessage()
    {
        return message;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }

    public void setHandle(String handle)
    {
        this.handle = handle;
    }
    public String getHandle()
    {
        return handle;
    }

    public void setProfileImageUrl(String profileImageUrl)
    {
        this.profileImageUrl = profileImageUrl;
    }
    public String getProfileImageUrl()
    {
        return profileImageUrl;
    }

    public void setCreatedAt(String createdAt)
    {
        this.createdAt = createdAt;
    }
    public String getCreatedAt()
    {
        return createdAt;
    }
}
