package com.Bootcamp.TwitterBasic.dao.daoImpl;

import com.Bootcamp.TwitterBasic.dao.Dao;
import com.Bootcamp.TwitterBasic.models.StatusPojo;

import com.Bootcamp.TwitterBasic.service.serviceImpl.RetrieveTimeline;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import twitter4j.Twitter;
import twitter4j.TwitterException;

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

    public void insertIntoDB(RetrieveTimeline retrieveTimeline, Twitter twitter)throws TwitterException
    {
        Session session =null;
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<StatusPojo> statusPojos = retrieveTimeline.getTimeLine(twitter);
        for(StatusPojo statusPojo : statusPojos)
        {
            session.persist(statusPojo);
            transaction.commit();
        }
    }
}