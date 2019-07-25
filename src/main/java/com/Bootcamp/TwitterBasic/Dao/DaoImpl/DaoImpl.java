package com.Bootcamp.TwitterBasic.Dao.DaoImpl;

import com.Bootcamp.TwitterBasic.Dao.Dao;

import java.util.HashMap;

public class DaoImpl implements Dao {

    HashMap<String, String> people = new HashMap<>();

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
