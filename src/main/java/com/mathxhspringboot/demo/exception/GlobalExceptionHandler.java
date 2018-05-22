package com.mathxhspringboot.demo.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
public class GlobalExceptionHandler {
    public  static final String  DEFAULT_ERROR_VIEW = "errorpage";

    /**
    *  只需要在Controller中抛出Exception，当然我们可能会有多种不同的Exception。然后在@ControllerAdvice类中，根据抛出的具体
    *  Exception类型匹配@ExceptionHandler中配置的异常类型来匹配错误映射和处理。返回error模板html网页。
    */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e) throws  Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e.getMessage());
        mav.addObject("url", request.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }

    /**
    *  返回json错误串
    */
    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public  ErrorInfo<String> jsonErrorHandler(HttpServletRequest request, Exception e) throws Exception {
        ErrorInfo<String> errorInfo = new ErrorInfo<>();
        errorInfo.setMessage(e.getMessage());
        errorInfo.setCode(ErrorInfo.ERROR);
        errorInfo.setData("Json Error Info");
        errorInfo.setUrl(request.getRequestURL().toString());
        return errorInfo;
    }
}
