package com.example.bellIntegrator.service.user;

import com.example.bellIntegrator.view.UserView;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface UserService {

    void add (@Valid UserView user);

    List<UserView> users();
}
