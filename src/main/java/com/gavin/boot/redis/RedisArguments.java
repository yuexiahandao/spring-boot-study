package com.gavin.boot.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by gavin on 17-6-8.
 */
@PropertySource("classpath:system.properties")
@ConfigurationProperties(prefix = "spring.redis.database")
@Component
public class RedisArguments {
    private String host;
    private String port;
    private String index;

    public String getHost() {
//        if (host==null)
//            return "localhost";
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        if (port==null)
            return "6379";
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getIndex() {
        if (index==null)
            return "2";
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

}
