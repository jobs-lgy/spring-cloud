package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author leongfeng created on 2018-01-25.
 */
@RestController
public class ConsumerController {

    @Autowired
    HelloService service;

    @GetMapping("/feign-consumer")
    public String hello(){
        return service.hello();
    }
}
