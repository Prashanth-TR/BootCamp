package com.Bootcamp.TwitterBasic.dao;

import com.Bootcamp.TwitterBasic.dao.daoImpl.DaoImpl;

public class DaoFactory {
    public static Dao getDao()
    {
        return new DaoImpl();
    }
}
