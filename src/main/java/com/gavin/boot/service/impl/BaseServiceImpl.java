package com.gavin.boot.service.impl;

import com.gavin.boot.service.BaseService;

/**
 * Created by gavin on 17-3-30.
 */
public class BaseServiceImpl implements BaseService {
    @Override
    public void doSomething() {
        System.out.println("BaseServiceImpl doSomething");
    }
}
