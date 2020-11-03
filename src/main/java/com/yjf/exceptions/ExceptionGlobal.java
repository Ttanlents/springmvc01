package com.yjf.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author 余俊锋
 * @date 2020/10/14 17:32
 * @Description
 */
@ControllerAdvice
public class ExceptionGlobal {

    @ExceptionHandler(Exception.class)
    public String error(){
        return "error";
    }
}
