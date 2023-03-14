package org.example;

import org.example.annotation.AnnotationApplicationContext;
import org.example.annotation.ApplicationContext;
import org.example.controller.UserController;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
        ApplicationContext context = new AnnotationApplicationContext("org.example");
        UserController userController = (UserController) context.getBean(UserController.class);
//        System.out.println(userController.name);
        userController.add_UserController();
    }
}