package org.example.dao.impl;

import org.example.annotation.Bean;
import org.example.dao.UserDao;


@Bean
public class UserDaoImpl implements UserDao {

    public String name;
    @Override
    public void add_UserDao() {
        System.out.println("使用UserDao");
    }

    public UserDaoImpl() {
    }

    public UserDaoImpl(String name) {
        this.name = name;
    }
}
