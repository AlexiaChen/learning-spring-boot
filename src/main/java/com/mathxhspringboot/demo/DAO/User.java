package com.mathxhspringboot.demo.DAO;

/**
 * Created by MathxH on 2018/3/29.
 */
public class User {
    private String name;
    private Integer age;
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
