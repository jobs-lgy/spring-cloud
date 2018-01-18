package com.leong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author leongfeng created on 2018-01-02.
 */
@RestController
public class HelloController {

    @Autowired
    private Registration registration;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello Eureka: " + registration.getHost() + ", service_id: " + registration.getServiceId() + ", port:" +
                registration.getPort();
    }
}
