package com.mathxhspringboot.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by MathxH on 2018/3/27.
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @RequestMapping("/")
    public  String index(ModelMap map){
        map.addAttribute("host","Hello Thyleaf");
        return "index";
    }
}