package com.zhezhuo.biz.manager.impl;

import com.zhezhuo.model.entity.ItemDO;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shaka on 15/8/13.
 */
public class RedisCacheManagerImplTest {

    RedisCacheManagerImpl cacheManager;

    @org.junit.Before
    public void setUp() throws Exception {
        cacheManager = new RedisCacheManagerImpl();
        cacheManager.init();
    }

    @org.junit.Test
    public void testPut() throws Exception {
        List<ItemDO> itemDOList = new ArrayList<ItemDO>();

        for(int i = 0; i < 10; i++){
            ItemDO itemDO = new ItemDO();
            itemDO.setUserId(1111 + i);
           // itemDO.setImagePath("image" + i);

            itemDOList.add(itemDO);
        }

        boolean result = cacheManager.put("itemDOList", itemDOList);

        Assert.isTrue(result);

        Object o = cacheManager.get("itemDOList");

        Assert.notNull(o);
    }

    @org.junit.Test
    public void testPut1() throws Exception {

    }

    @org.junit.Test
    public void testGet() throws Exception {

    }

    @org.junit.Test
    public void testGet1() throws Exception {

    }

    @org.junit.Test
    public void testInvaild() throws Exception {

    }
}