package com.Bootcamp.TwitterBasic.dao.daoImpl;

import com.Bootcamp.TwitterBasic.dao.StatusPojoDao;
import com.Bootcamp.TwitterBasic.models.StatusPojo;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import javax.inject.Inject;
import java.util.List;


public class StatusPojoDaoImpl extends AbstractDAO<StatusPojo> implements StatusPojoDao {

    @Inject
    public StatusPojoDaoImpl(SessionFactory sessionFactory)
    {
        super(sessionFactory);
    }

    public long create(StatusPojo statusPojo) {
        return persist(statusPojo).getId();
    }


    public List<StatusPojo> findAll() {
        List<StatusPojo> ls = list(namedQuery("findAll"));
        return ls;
    }
}
