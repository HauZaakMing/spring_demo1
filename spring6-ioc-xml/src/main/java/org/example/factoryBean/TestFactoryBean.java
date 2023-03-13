package org.example.factoryBean;

import org.example.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFactoryBean {
    @Test
    public  void go(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean_factoryBean.xml");
        //通过factorybean去取bean的时候需要通过ID去取，才能取到里面真正的bean
        User bean = (User)context.getBean("user");
        System.out.println(bean);

    }
}
