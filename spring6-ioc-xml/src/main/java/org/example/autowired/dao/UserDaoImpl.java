package org.example.autowired.dao;

public class UserDaoImpl implements UserDao{
    @Override
    public void addUser() {
        System.out.println("添加User");
    }
}
