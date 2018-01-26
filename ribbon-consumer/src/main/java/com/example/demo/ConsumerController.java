package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;

/**
 * @author leongfeng created on 2018-01-25.
 */
@RestController
public class ConsumerController {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HelloService service;

    @RequestMapping("/ribbon-consumer")
    public String helloConsumer() {
        // 没有回调方法
        // return restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
        return service.helloService();
    }


    @RequestMapping("/users/{id}")
    public String getUserById(@PathVariable long id) throws ExecutionException, InterruptedException {
//        return service.getUserById(id);
        return service.getUserByIdAsync(String.valueOf(id)).get();
    }
}
