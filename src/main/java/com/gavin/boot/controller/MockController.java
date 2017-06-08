package com.gavin.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gavin on 17-3-30.
 */
// @Controller
@RestController
public class MockController {
    @RequestMapping("/hello")
    public String hello() {
        return "hello world!";
    }
}
