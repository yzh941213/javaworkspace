package com.dao.impl;

import com.dao.TestDao;
import com.entity.Test;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import system.cache.MyCache;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yzh on 2017/9/1.
 */
@Repository
public class TestDaoImpl implements TestDao {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * 查询
     * @return
     */
    @Override
    public List<Test> list() {
        Query query = sessionFactory.getCurrentSession().createQuery("from com.entity.Test");
        return query.list();
    }

    /**
     *验证事物回滚
     */
    @Override
    public void add() {
            Session session = sessionFactory.getCurrentSession();
            Query query3= session.createSQLQuery("INSERT INTO test (name) VALUES('菜穗子')");
            query3.executeUpdate();
    }

    /**
     *
     */
    @Override
    public void update() {

    }
}
