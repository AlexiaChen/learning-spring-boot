package com.mathxhspringboot.demo.exception;

public class MyException extends Exception {
    public MyException(String msg) {

        this.msg = msg;
    }

    @Override
    public String getMessage(){
        return msg;
    }

    private String msg;

}
