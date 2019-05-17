package com.example.bellIntegrator.user.controller;

import com.example.bellIntegrator.user.service.UserService;
import com.example.bellIntegrator.user.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Контроллер для обработки запросов по юзерам.
 */
@RestController
@RequestMapping(value = "/api/user", produces = APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Фильтр по юзерам.
     */
    @PostMapping("/list")
    public List<UserViewListOut> list (@RequestBody UserViewListIn view) {
        List<UserViewListOut> views = userService.userFilter(view);
        return views;
    }

    /**
     * Запрос юзера по идентификатору.
     */
    @RequestMapping(value = "/{id:[\\d]+}", method = GET)
    public UserViewGet userById (@PathVariable("id") Long id) {
        UserViewGet view = userService.userById(id);
        return view;
    }

    /**
     * Изменение существующего юзера.
     */
    @PostMapping("/update")
    public void update(@RequestBody UserViewUpdate view) {
        userService.update(view);
    }

    /**
     * Добавление нового юзера.
     */
    @PostMapping("/save")
    public void save(@RequestBody UserViewSave view) {
        userService.add(view);
    }
}
