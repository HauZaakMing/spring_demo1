package org.example.service;

import jakarta.annotation.Resource;
import org.example.dao.UserDao;
import org.springframework.stereotype.Service;


@Service(value = "userService")
public class UserServiceImpl implements UserService{

    @Resource(name = "userDao")
    UserDao userDao;
    @Override
    public void add_userService() {
        System.out.println("执行userService方法");
        userDao.add_userDao();
    }
}
