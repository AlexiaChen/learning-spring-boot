package com.mathxhspringboot.demo.service;

import com.mathxhspringboot.demo.dao.User;

import java.util.List;

public interface UserService {


    void createUserTable();

    /**
    * 新增一个用户
    * @param name
    * @param age
    */
    void create(String name, Integer age);

    /**
     * 根据name删除一个用户高
     * @param name
     */
    void deleteByName(String name);

    /**
     * 获取用户总量
     */
    Integer getUserCount();

    /**
    *  根据名字查找用户
    */
    List<User> getUsersByName(String name);

    /**
     * 删除所有用户
     */
    void deleteAllUsers();

}
