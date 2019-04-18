package com.example.bellIntegrator.service.usersDoc;

import com.example.bellIntegrator.view.UserDocView;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface UsersDocService {

    void add (@Valid UserDocView udv);

    List<UserDocView> usersDocs();
}
