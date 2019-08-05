package com.Bootcamp.TwitterBasic.dao;

import com.Bootcamp.TwitterBasic.models.StatusPojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface Dao {

    HashMap<String, String> people = new HashMap<>();
    List<StatusPojo> cache = new ArrayList<>();

    void setCache(List<StatusPojo> statusPojos);

    List<StatusPojo> getCache();

    String getHandle(String name);

    void putHandle(String name, String reference);
}
