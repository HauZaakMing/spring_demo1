package org.example.service.impl;

import org.example.annotation.Bean;
import org.example.annotation.DI;
import org.example.dao.UserDao;
import org.example.service.UserService;

@Bean
public class UserServiceImpl implements UserService {

    public String name;
    @DI
    private UserDao userDao;
    @Override
    public void add_UserService() {
        System.out.println( "使用UserService");
        userDao.add_UserDao();
    }


    public UserServiceImpl() {
    }

    public UserServiceImpl(String name) {
        this.name = name;
    }
}
