package com.example.bellIntegrator.user.controller;

import com.example.bellIntegrator.office.view.OfficeViewGet;
import com.example.bellIntegrator.other.view.DataView;
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
    public String list (@RequestBody UserViewListIn view) {
        List<UserViewListOut> views = userService.userByOffice(view.office.getId());
        DataView dataView = new DataView();
        dataView.data = views.toString();
        return dataView.toString();
    }

    @RequestMapping(value = "/{id:[\\d]+}", method = GET)
    public String userById (@PathVariable("id") Long id) {
        UserViewGet view = userService.userById(id);
        DataView dataView = new DataView();
        dataView.data = view.toString();
        return dataView.toString();
    }

    @PostMapping("/update")
    public String update(@RequestBody UserViewUpdate view) {
        userService.update(view);
        DataView dataView = new DataView();
        dataView.data = "{result:success}";
        return  dataView.toString();
    }

    @PostMapping("/save")
    public String save(@RequestBody UserViewSave view) {
        userService.add(view);
        DataView dataView = new DataView();
        dataView.data = "{result:success}";
        return  dataView.toString();
    }
}
