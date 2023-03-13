package org.example;

import org.example.ditest.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {


    private Logger logger = LoggerFactory.getLogger(TestUser.class);
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean_scope.xml");
        System.out.println("hello, piggy!");
        Employee emp = (Employee) context.getBean("emp");
        Employee emp1 = (Employee) context.getBean("emp");

        System.out.println("emp1 = " + emp1);
        System.out.println("emp = " + emp);
        context.close();


//        System.out.println("根據ID获取bean："+user);
//        user.run();
//
//        //根据类型获取时，要求对应类型的对象只能存在一个
//        //否则就会产生非唯一定义异常NoUniqueBeanDefinitionException
//        User user1 = context.getBean(User.class);
//        System.out.println("根据类型获取Bean"+user1);
//
//        User user2 = context.getBean("user", User.class);
//        System.out.println("根据类型和ID获取bean"+user2);
    }
}
