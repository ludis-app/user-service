package com.ludis.users.controller;


import com.ludis.users.model.User;
import com.ludis.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RibbonClient(name = "users")
@RequestMapping("users/")
public class UserController {
    private final UserService userService;

    @Autowired
    RestTemplate restTemplate;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value="all")
    public List<User> getAccountsByEmpId() {
        List<User> userList = userService.findAllUsers();
        return userList;
    }

    @GetMapping(value="create")
    public void createUsers() {
        userService.createUserItems();
    }

    @GetMapping("/ribbongetsteps")
    public String getStepsInstance()
    {
        String url = "http://users/steps/port";
        return "Currently hitting instance running on port: " +
                restTemplate.getForObject(url, String.class);
    }
}
