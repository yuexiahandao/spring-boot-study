package com.gavin.boot;

import com.gavin.boot.service.BaseService;
import com.gavin.boot.service.MockService;
import com.gavin.boot.service.impl.BaseServiceImpl;
import com.gavin.boot.service.impl.MockServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by gavin on 17-3-30.
 */
@Configuration
public class ImportConfiguration {
    @Bean
    public BaseService baseService() {
        return new BaseServiceImpl();
    }

    @Bean
    public MockService mockService() {
        // 依赖关系可以这么指定，Spring有拦截器，方法只会调用一次
        return new MockServiceImpl(baseService());
    }
}
