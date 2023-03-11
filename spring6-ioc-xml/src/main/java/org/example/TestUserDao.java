package org.example;

import org.example.bean.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserDao {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //用接口去接bean的话，要是有多个实现对象，就会出现异常
//        UserDao bean = context.getBean(UserDao.class);
//        System.out.println(bean);
//        bean.run();

    }
}
