package com.mathxhspringboot.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by MathxH on 2018/3/27.
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @RequestMapping("/")
    public  String index(ModelMap map){
        map.addAttribute("host","Hello Thymeleaf");
        map.addAttribute("author","MathxH");
        return "index";
    }
}
