package org.example.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.BeanDefinitionDsl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJDBC {
    @Test
    public void demo1(){
        DruidDataSource datasource = new DruidDataSource();
        ApplicationContext context = new ClassPathXmlApplicationContext("bean_jdbc.xml");
        DruidDataSource bean = context.getBean(DruidDataSource.class);
        datasource.setUrl(bean.getUrl());
        datasource.setUsername(bean.getUsername());
        datasource.setPassword(bean.getPassword());
        datasource.setDriver(bean.getDriver());
    }
}
