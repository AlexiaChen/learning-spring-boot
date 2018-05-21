package com.mathxhspringboot.demo.web;

import com.mathxhspringboot.demo.dao.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by MathxH on 2018/3/29.
 */
@RestController

public class UserController {

    static Map<Long,User> users =
            Collections.synchronizedMap(new HashMap<Long,User>());

    @ApiOperation(value="获取用户列表",notes="")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUserList(){
        List<User> tempUsers = new ArrayList<User>(users.values());
        return tempUsers;
    }

    @ApiOperation(value="创建用户",notes = "根据User对象创建用户")
    @ApiImplicitParam(name="user",value="用户详情实体User",required=true,dataType="User")
    @RequestMapping(value="/users", method = RequestMethod.POST)
    public String postUser(@RequestBody User user){
        users.put(user.getId(),user);
        return "success";
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long",paramType = "path")
    @RequestMapping(value="/users/{id}", method = RequestMethod.GET)
    public  User getUser(@PathVariable Long id){
        return users.get(id);
    }


    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long",paramType = "path"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @RequestMapping(value="/users/{id}", method = RequestMethod.PUT)
    public String putUser(@PathVariable Long id,@RequestBody User user){

        User tempUser = users.get(id);
        tempUser.setName(user.getName());
        tempUser.setAge(user.getAge());
        users.put(user.getId(),tempUser);
        return "success";
    }

    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long",paramType = "path")
    @RequestMapping(value="/users/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id){
        users.remove(id);
        return "success";
    }


}
