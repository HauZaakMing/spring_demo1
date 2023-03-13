package org.example.dao;


import org.springframework.stereotype.Repository;

@Repository(value = "userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void add_userDao() {
        System.out.println("执行userDao");
    }
}
