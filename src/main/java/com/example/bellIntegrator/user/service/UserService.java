package com.example.bellIntegrator.user.service;

import com.example.bellIntegrator.user.view.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface UserService {

    void add (@Valid UserViewSave user);

    void update (@Valid UserViewUpdate user);

    List<UserViewListOut> userByOffice(Long id);

    UserViewGet userById(Long id);
}
