package com.example.bellIntegrator.userDoc.service;

import com.example.bellIntegrator.userDoc.view.UserDocView;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface UsersDocService {

    void add (@Valid UserDocView udv);

    List<UserDocView> usersDocs();
}
