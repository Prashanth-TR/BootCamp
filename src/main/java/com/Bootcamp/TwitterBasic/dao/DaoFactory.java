package com.Bootcamp.TwitterBasic.dao;

import com.Bootcamp.TwitterBasic.dao.daoImpl.DaoImpl;
import com.Bootcamp.TwitterBasic.dao.daoImpl.StatusPojoDaoImpl;
import com.Bootcamp.TwitterBasic.models.StatusPojo;
import org.hibernate.SessionFactory;

public class DaoFactory {
    public static Dao getDao()
    {
        return new DaoImpl();
    }
}
