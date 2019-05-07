package com.example.bellIntegrator.additionalLogic.controller;

import com.example.bellIntegrator.additionalLogic.view.DataView;
import com.example.bellIntegrator.additionalLogic.view.ErrorView;
import com.example.bellIntegrator.additionalLogic.view.SuccessView;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(
            Object object,
            MethodParameter methodParameter,
            MediaType mediaType,
            Class aClass,
            ServerHttpRequest serverHttpRequest,
            ServerHttpResponse serverHttpResponse
    ) {
        if (object instanceof SuccessView) {
            return object;
        }
        if (object instanceof ErrorView) {
            return object;
        }
        DataView view = new DataView();
        view.data = object;
        return view;
    }
}
