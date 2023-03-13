package org.example.factoryBean;

import org.example.User;
import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean {
    @Override
    public User getObject() throws Exception {
        User u = new User();
        return u;
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
