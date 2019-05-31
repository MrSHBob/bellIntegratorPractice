package com.example.bellIntegrator.response.controller;

import com.example.bellIntegrator.response.view.ErrorView;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс обработки исключений при обработке запросов.
 */
@RestControllerAdvice
public class SomeExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ErrorView handleException (Exception e) {
        ErrorView errorView = new ErrorView();
        errorView.error = e.getMessage();
        return errorView;
    }

    /**
     * Метод перехватывает возникающие NullPointerException
     */
    @ExceptionHandler(NullPointerException.class)
    public ErrorView handleException (NullPointerException e) {
        ErrorView errorView = new ErrorView();
        errorView.error = "answer is empty";
        return errorView;
    }

    /**
     * Метод перехватывает возникающие ConstraintViolationException
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ErrorView handleException (ConstraintViolationException e) {
        List<String> errors = new ArrayList<>();
        for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
            String message = violation.getMessage();
            errors.add(message);
        }

        ErrorView errorView = new ErrorView();
        errorView.error = StringUtils.arrayToDelimitedString(errors.toArray(),", ");
        return errorView;
    }
}
