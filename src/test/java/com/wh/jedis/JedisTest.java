package com.wh.jedis;

import com.wh.jedis.util.JedisConnectionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

/**
 * @author CXWWH
 * @create 2022-10-17-16:51
 * @
 **/
public class JedisTest {

    private Jedis jedis;

    // 建立连接
    @BeforeEach
    public void getJedis(){

        jedis = JedisConnectionFactory.getJedis();
    }

    // 测试
    @Test
    public void test(){

        jedis.set("wish", "tomorrow will bw better");

        String wish = jedis.get("wish");
        System.out.println(wish);
    }

    // 释放资源
    @AfterEach
    public void relraseResource(){

        jedis.close();
    }
}
