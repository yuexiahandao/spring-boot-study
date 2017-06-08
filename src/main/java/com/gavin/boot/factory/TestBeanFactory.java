package com.gavin.boot.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by gavin on 17-6-9.
 */
@Component("testBean")
@Scope("singleton")
@Configuration
public class TestBeanFactory<T> implements FactoryBean<T> {
    private Class<T> aClass;
    private T object;

    public TestBeanFactory() {
        this.aClass = Class.class.cast(TestBean.class);
    }

    @PostConstruct
    public void initMethod() {
        System.out.println("init test bean");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("test bean stop");
    }

    @Override
    public T getObject() throws Exception {
        synchronized (TestBeanFactory.class) {
            if (object==null)
                object = aClass.cast(new TestBean());
        }
        return object;
    }

    @Override
    public Class<?> getObjectType() {
        return aClass;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
