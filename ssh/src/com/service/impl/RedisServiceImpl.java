package com.service.impl;

import com.dao.TestDao;
import com.entity.Test;
import com.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private TestDao testDao;

    /**
     * @return
     */
    @Cacheable(value = "list_test",key = "'list_test'")
    @Override
    public List<Test> listTest() {
        List<Test>list = testDao.list();
        return list;
    }


    @CacheEvict(value = "list_test",key = "'list_test'",allEntries = true,beforeInvocation = true)
    @Override
    public void add() {
        testDao.add();
    }
}
