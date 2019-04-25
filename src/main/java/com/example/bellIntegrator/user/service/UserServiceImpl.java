package com.example.bellIntegrator.user.service;

import com.example.bellIntegrator.office.model.Office;
import com.example.bellIntegrator.office.view.OfficeViewListOut;
import com.example.bellIntegrator.user.dao.UserDao;
import com.example.bellIntegrator.user.model.User;
import com.example.bellIntegrator.other.mapper.MapperFacade;
import com.example.bellIntegrator.user.view.*;
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
    public void add(UserViewSave view) {
        User user = new User();





        dao.save(user);
    }

    @Override
    @Transactional
    public void update(UserViewUpdate view) {
        User user = new User();




        dao.update(user);
    }

    @Override
    public List<UserView> users() {
        List<User> all = dao.all();
        return mapperFacade.mapAsList(all, UserView.class);
    }

    @Override
    public List<UserViewListOut> userByOffice(Long officeId) {
        List<User> users = dao.findByOffice(officeId);
        return mapperFacade.mapAsList(users, UserViewListOut.class);
    }

    @Override
    public UserViewGet userById(Long id) {
        User user = dao.loadById(id);
        UserViewGet view = new UserViewGet();





        return null;
    }
}
