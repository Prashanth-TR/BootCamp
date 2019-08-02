package com.Bootcamp.TwitterBasic.dao.daoImpl;

import com.Bootcamp.TwitterBasic.dao.Dao;
import com.Bootcamp.TwitterBasic.models.StatusPojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DaoImpl implements Dao {

    HashMap<String, String> people = new HashMap<>();

    List<StatusPojo> cache = new ArrayList<>();

    public void setCache(List<StatusPojo> statusPojos)
    {
        this.cache = statusPojos;
    }

    public List<StatusPojo> getCache()
    {
        return cache;
    }
    public DaoImpl()
    {
        //people.put("Raghav", "@raghav11031997");
        people.put("Prashanth", "@prachoo2198_tr");
        people.put("Khoros", "@Khoros");
    }

    public String getHandle(String name)
    {
        return people.get(name);
    }

    public void putHandle(String name, String handle)
    {
        people.put(name, handle);
    }

}
