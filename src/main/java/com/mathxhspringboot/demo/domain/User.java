package com.mathxhspringboot.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by MathxH on 2018/3/29.
 */
@Entity
public class User {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

    @Id
    @GeneratedValue
    private Long id;

    public User(){

    }

    public User(String name, Integer age){
        this.name = name;
        this.age = age;
    }

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
