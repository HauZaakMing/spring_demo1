package org.example.autowired.service;

public class UserServiceImpl implements UserService{
    @Override
    public void addUserService() {
        System.out.println("调用userDao");
    }
}
