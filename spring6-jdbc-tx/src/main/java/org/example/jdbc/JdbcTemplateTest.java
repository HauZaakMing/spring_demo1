package org.example.jdbc;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;
import java.util.Map;

@SpringJUnitConfig(locations = "classpath:beans.xml")
public class JdbcTemplateTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Test
    public void update(){
        String sql = "INSERT INTO t_emp VALUES(NULL,?,?,?)";
        Object []params = {"小猪猪6",6,"男"};
        int rows = jdbcTemplate.update(sql, params);
        System.out.println(rows);
    }


    @Test
    public void selectObject(){
        String sql = "SELECT count(*) FROM t_emp ";
//        List<Emp> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class));
        Integer integer = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(integer);
//        for (Emp e :
//                query) {
//            System.out.println(e.getName());
//        }
    }
}
