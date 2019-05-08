package com.example.bellIntegrator.user.controller;

import com.example.bellIntegrator.additionalLogic.view.SuccessView;
import com.example.bellIntegrator.user.service.UserService;
import com.example.bellIntegrator.user.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/api/user", produces = APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/list")
    public List<UserViewListOut> list (@RequestBody UserViewListIn view) {
        List<UserViewListOut> views = userService.userByOffice(view.officeId);
        return views;
    }

    @RequestMapping(value = "/{id:[\\d]+}", method = GET)
    public UserViewGet userById (@PathVariable("id") Long id) {
        UserViewGet view = userService.userById(id);
        return view;
    }

    @PostMapping("/update")
    public SuccessView update(@RequestBody UserViewUpdate view) {
        userService.update(view);
        SuccessView success = new SuccessView();
        return  success;
    }

    @PostMapping("/save")
    public SuccessView save(@RequestBody UserViewSave view) {
        userService.add(view);
        SuccessView success = new SuccessView();
        return  success;
    }
}
