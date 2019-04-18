package com.example.bellIntegrator.service.user;

import com.example.bellIntegrator.dao.user.UserDao;
import com.example.bellIntegrator.model.User;
import com.example.bellIntegrator.model.mapper.MapperFacade;
import com.example.bellIntegrator.view.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao dao;
    private final MapperFacade mapperFacade;

    @Autowired
    public UserServiceImpl(UserDao dao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    @Transactional
    public void add(UserView view) {
        User user = new User();
        user.setOffice(view.office);
        user.setFirstName(view.firstName);
        user.setSecondName(view.secondName);
        user.setMiddleName(view.middleName);
        user.setPosition(view.position);
        user.setPhone(view.phone);                                      //вероятно нужно будет добавить поля,
        dao.save(user);                                                 //и поменять поля во вью и модели
    }

    @Override
    @Transactional
    public List<UserView> users() {
        List<User> all = dao.all();
        return mapperFacade.mapAsList(all, UserView.class);
    }
}
