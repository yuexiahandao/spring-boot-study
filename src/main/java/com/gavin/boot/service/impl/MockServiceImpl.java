package com.gavin.boot.service.impl;

import com.gavin.boot.service.BaseService;
import com.gavin.boot.service.MockService;

/**
 * Created by gavin on 17-3-30.
 */
public class MockServiceImpl implements MockService {
    private BaseService baseService;

    public MockServiceImpl(BaseService baseService) {
        this.baseService = baseService;
    }

    public void doSomething() {
        System.out.println("mockService MockServiceImpl doSomething");
        baseService.doSomething();
    }
}
