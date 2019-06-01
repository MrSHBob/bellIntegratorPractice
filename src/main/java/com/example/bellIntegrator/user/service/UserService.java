package com.example.bellIntegrator.user.service;

import com.example.bellIntegrator.user.view.UserViewGet;
import com.example.bellIntegrator.user.view.UserViewListIn;
import com.example.bellIntegrator.user.view.UserViewListOut;
import com.example.bellIntegrator.user.view.UserViewSave;
import com.example.bellIntegrator.user.view.UserViewUpdate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import java.util.List;

/**
 * Интерфейс сервиса для юзера.
 */
@Validated
public interface UserService {

    /**
     * Добавление нового юзера.
     */
    void add (@Valid UserViewSave user);

    /**
     * Изменение юзера.
     */
    void update (@Valid UserViewUpdate user);

    /**
     * Фильтр юзеров.
     */
    List<UserViewListOut> userFilter(@Valid UserViewListIn view);

    /**
     * Возвращает юзера по id.
     */
    UserViewGet userById(Long id);
}
