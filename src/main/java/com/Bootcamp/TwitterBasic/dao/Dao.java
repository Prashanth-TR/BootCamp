package com.Bootcamp.TwitterBasic.dao;

import java.util.HashMap;

public interface Dao {

    HashMap<String, String> people = new HashMap<>();

    String getHandle(String name);

    void putHandle(String name, String reference);
}
