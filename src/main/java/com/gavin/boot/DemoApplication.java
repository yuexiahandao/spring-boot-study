package com.gavin.boot;

import com.gavin.boot.service.MockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by gavin on 17-3-30.
 */
@SpringBootApplication
@PropertySource("classpath:system.properties")
@Import(ImportConfiguration.class)
public class DemoApplication {
    @Autowired
    private MockService mockService;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
