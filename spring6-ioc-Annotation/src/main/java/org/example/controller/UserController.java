package org.example.controller;

import jakarta.annotation.Resource;
import org.example.service.UserService;
import org.springframework.stereotype.Controller;


@Controller(value = "userController")
public class UserController {

    @Resource(name = "userService")
    UserService userService;


    public void add_userController(){
        System.out.println("执行controller");
        userService.add_userService();
    }
}
