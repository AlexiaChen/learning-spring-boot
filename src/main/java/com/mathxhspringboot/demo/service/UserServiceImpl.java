package com.mathxhspringboot.demo.service;

import com.mathxhspringboot.demo.dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createUserTable(){
        jdbcTemplate.update("CREATE TABLE USER (" +
                "name varchar(64) NOT NULL," +
                "age int NOT NULL" +
                ")");
    }

    @Override
    public void create(String name, Integer age) {
        jdbcTemplate.update("INSERT INTO USER(NAME,AGE) VALUES(?,?)",name,age);
    }

    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update("DELETE FROM USER WHERE NAME = ?",name);
    }

    @Override
    public Integer getUserCount() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM USER",Integer.class);
    }

    @Override
    public List<User> getUsersByName(String name){
        return jdbcTemplate.queryForList("SELECT * FROM USER WHERE NAME=?",User.class,name);
    }

    @Override
    public void deleteAllUsers() {
        jdbcTemplate.update("DELETE  FROM  USER");
    }
}
