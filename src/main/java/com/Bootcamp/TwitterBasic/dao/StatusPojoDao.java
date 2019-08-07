package com.Bootcamp.TwitterBasic.dao;

import com.Bootcamp.TwitterBasic.models.StatusPojo;
import io.dropwizard.hibernate.AbstractDAO;
import javassist.tools.reflect.Sample;
import org.hibernate.SessionFactory;

import java.util.List;

public interface StatusPojoDao {
    long create(StatusPojo statusPojo);
    List<StatusPojo> findAll();
}
