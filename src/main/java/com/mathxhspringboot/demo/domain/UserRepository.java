package com.mathxhspringboot.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    // 这可以直接通过方法名就自动创建查询了
    User findByNameAndAge(String name, Integer age);

    //也可以通过下面的注解来创建查询
    @Query("from User u where u.name=:name")
    List<User> findUserByName(@Param("name") String name);

}
