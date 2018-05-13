package com.mathxhspringboot.demo.web;

import com.mathxhspringboot.demo.DAO.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by MathxH on 2018/3/29.
 */
@RestController

public class UserController {

    static Map<Long,User> users =
            Collections.synchronizedMap(new HashMap<Long,User>());

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUserList(){
        List<User> tempUsers = new ArrayList<User>(users.values());
        return tempUsers;
    }

    @RequestMapping(value="/users", method = RequestMethod.POST)
    public String postUser(@ModelAttribute User user){
        users.put(user.getId(),user);
        return "success";
    }

    @RequestMapping(value="/users/{id}", method = RequestMethod.GET)
    public  User getUser(@PathVariable Long id){
        return users.get(id);
    }

    @RequestMapping(value="/users/{id}", method = RequestMethod.PUT)
    public String putUser(@PathVariable Long id,@ModelAttribute User user){

        User tempUser = users.get(id);
        tempUser.setName(user.getName());
        tempUser.setAge(user.getAge());
        users.put(user.getId(),tempUser);
        return "success";
    }

    @RequestMapping(value="/users/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id){
        users.remove(id);
        return "success";
    }


}
