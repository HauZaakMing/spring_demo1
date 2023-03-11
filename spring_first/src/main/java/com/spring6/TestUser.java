package com.spring6;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {

    private Logger logger = LoggerFactory.getLogger(TestUser.class);

    @Test
    public void testl4j(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        User u = (User) ac.getBean("user");
        u.add();
        logger.info("####执行成功####");
    }
    @Test
    public void testUserObject(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User user = (User) context.getBean("user");
        User user1 = (User) context.getBean("user");
        System.out.println(user);
        System.out.println(user1);
        user.add();
    }

}
