package com.wh.jedis.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author CXWWH
 * @create 2022-10-17-17:06
 * @
 **/
public class JedisConnectionFactory {

    private static final JedisPool JEDIS_POOL;

    static{

        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(8);// 最大连接数
        config.setMaxIdle(8);// 最大空闲连接
        config.setMinIdle(0);// 最小空闲连接
        config.setMaxWaitMillis(1000);// 超时时间

        JEDIS_POOL = new JedisPool(
                 config,
                "192.168.200.131",
                6379,
                1000,
                "CXWWH999");
    }

    public static Jedis getJedis(){

        return JEDIS_POOL.getResource();
    }
}
