package com.pro.sky.KursWork2_0.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExceptionApp extends IllegalArgumentException{
    public ExceptionApp(String s) {
        super(s);
    }
}
