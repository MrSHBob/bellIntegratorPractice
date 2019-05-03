package com.example.bellIntegrator.other.controller;

import com.example.bellIntegrator.other.view.ErrorView;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class SomeExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleException (Exception e) {
        ErrorView errorView = new ErrorView();
        errorView.text = "{" + e.getMessage() + "}";
        return errorView.toString();
    }
}
