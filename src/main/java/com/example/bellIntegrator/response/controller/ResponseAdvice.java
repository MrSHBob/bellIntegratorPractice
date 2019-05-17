package com.example.bellIntegrator.response.controller;

import com.example.bellIntegrator.response.view.DataView;
import com.example.bellIntegrator.response.view.ErrorView;
import com.example.bellIntegrator.response.view.SuccessView;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * Класс обработки HTTP-ответов до отправки
 */
@RestControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    /**
     * Метод добавляет информацию в Response.
     * Ни чего не делает для исключений,
     * возвращает SuccessView для всех void методов контроллеров,
     * все остальные ответы заворачивает в DataView.
     */
    @Override
    public Object beforeBodyWrite(
            Object object,
            MethodParameter methodParameter,
            MediaType mediaType,
            Class<? extends HttpMessageConverter<?>> aClass,
            ServerHttpRequest serverHttpRequest,
            ServerHttpResponse serverHttpResponse
    ) {
        if (object instanceof ErrorView) {
            return object;
        }
        if (methodParameter.getGenericParameterType().getTypeName().equals("void")) {
            return new SuccessView();
        }
        DataView view = new DataView();
        view.data = object;
        return view;
    }
}
