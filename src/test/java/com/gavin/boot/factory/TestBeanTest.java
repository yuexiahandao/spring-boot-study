package com.gavin.boot.factory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by gavin on 17-6-8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestBeanFactory.class})
//@ComponentScan({"com.gavin"})
public class TestBeanTest {
    private static Logger logger = LoggerFactory.getLogger(TestBeanTest.class);

    @Resource(name="testBean", type=TestBean.class)
    private TestBean testBean;
    @Autowired
    @Qualifier("testBean")
    private TestBeanFactory testBeanTest;

    @Test
    public void test() {
        System.out.println(testBean==null);
        System.out.println(testBean.getClass());
        System.out.println(testBean.getS());

        System.out.println(testBeanTest==null);
        System.out.println(testBeanTest.getClass());
    }
}
