package org.example.ditest;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEmployee {
    @Test
    public void testE(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean_ditest.xml");
        Employee emp1 = (Employee) context.getBean("emp3");
        emp1.work();
        emp1.show();
    }

}
