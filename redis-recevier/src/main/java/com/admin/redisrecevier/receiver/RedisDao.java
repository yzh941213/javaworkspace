package com.admin.redisrecevier.receiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.stereotype.Component;

@Component
public class RedisDao {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;


}
