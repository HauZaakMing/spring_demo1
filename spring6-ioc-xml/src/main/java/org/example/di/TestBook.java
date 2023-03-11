package org.example.di;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBook {

    @Test
    public void testSetter(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean_di.xml");
        Book bean = (Book)context.getBean("book");
        System.out.println(bean.toString());
    }
}
