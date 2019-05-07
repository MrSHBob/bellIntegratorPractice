package com.example.bellIntegrator.additionalLogic.controller;

import com.example.bellIntegrator.additionalLogic.view.ErrorView;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class SomeExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ErrorView handleException (Exception e) {
        ErrorView errorView = new ErrorView();
        errorView.error = "some mistery error";
        return errorView;
    }

    @ExceptionHandler(NullPointerException.class)
    public ErrorView handleException (NullPointerException e) {
        ErrorView errorView = new ErrorView();
        errorView.error = "answer is empty";
        return errorView;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ErrorView handleException (ConstraintViolationException e) {
        List<String> errors = new ArrayList<>();
        for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
            //String attribute = violation.getPropertyPath().toString();
            String message = violation.getMessage();
            errors.add(message);
        }

        ErrorView errorView = new ErrorView();
        errorView.error = StringUtils.arrayToDelimitedString(errors.toArray(),", ");
        //errorView.error = "fields filled wrong";
        return errorView;
    }
}
