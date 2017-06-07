package com.gavin.boot.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by gavin on 17-6-8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RedisConfiguration.class, TestRedis.class})
public class TestRedisTest {
    private static Logger logger = LoggerFactory.getLogger(TestRedisTest.class);

    @Autowired
    TestRedis testRedis;

    @Test
    public void set() {
        Item item = new Item();
        item.setValue("zhang");
        testRedis.set("test", 1L, item);
    }
}
