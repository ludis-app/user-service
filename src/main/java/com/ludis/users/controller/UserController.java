package com.ludis.users.controller;


import com.ludis.users.model.User;
import com.ludis.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("users/")

public class UserController {
    private final UserService userService;

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
}
