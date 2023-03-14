package org.example.controller;

import org.example.annotation.Bean;
import org.example.annotation.DI;
import org.example.service.UserService;


@Bean
public class UserController {
    public String name;

    @DI
    private UserService userService;

    public void add_UserController(){
        System.out.println("使用UserController");
        userService.add_UserService();

    }

    public UserController() {
    }

    public UserController(String name) {
        this.name = name;
    }
}
