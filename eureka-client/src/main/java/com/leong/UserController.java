package com.leong;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author leongfeng created on 2018-01-03.
 */
@RestController
public class UserController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/users/{id}")
    public User getUserById(@PathVariable long id) {
        User user = new User();
        user.setId(id);
        user.setUsername("Service " + port);
        return user;
    }
}
