package org.example.ditest;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEmployee {
    @Test
    public void testE(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean_diList.xml");
//        Employee emp1 = (Employee) context.getBean("emp");
//        String s = emp1.toString();
//        System.out.println(s);
        Department dept = (Department) context.getBean("dept");
        dept.empInfo();

    }

}
