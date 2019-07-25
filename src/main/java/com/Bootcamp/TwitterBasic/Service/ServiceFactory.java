package com.Bootcamp.TwitterBasic.Service;

import com.Bootcamp.TwitterBasic.Service.ServiceImpl.ServiceImpl;

public class ServiceFactory {

    public static Service getService()
    {
        return new ServiceImpl();
    }
}
