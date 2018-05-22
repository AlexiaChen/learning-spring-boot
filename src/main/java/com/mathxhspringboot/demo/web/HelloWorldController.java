package com.mathxhspringboot.demo.web;

/**
 * Created by MathxH on 2018/5/13.
 */

import com.mathxhspringboot.demo.exception.MyException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloWorld() {
        return "Hello World";
    }

    @RequestMapping(value = "/exception/hello",method = RequestMethod.GET)
    public  String helloException() throws  Exception{
        throw new Exception("hello Exception");
    }

    @RequestMapping(value = "/exception/json", method = RequestMethod.GET)
    public String jsonException() throws MyException {
        throw  new MyException("json Exception");
    }
}
