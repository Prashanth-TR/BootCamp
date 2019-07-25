package com.Bootcamp.TwitterBasic.Dao;

import com.Bootcamp.TwitterBasic.Dao.DaoImpl.DaoImpl;

public class DaoFactory {
    public static Dao getDao()
    {
        return new DaoImpl();
    }
}
