package com.example.bellIntegrator.service.usersDoc;

import com.example.bellIntegrator.dao.user.UserDao;
import com.example.bellIntegrator.dao.usersDoc.UserDocDao;
import com.example.bellIntegrator.model.User;
import com.example.bellIntegrator.model.UsersDoc;
import com.example.bellIntegrator.model.mapper.MapperFacade;
import com.example.bellIntegrator.view.UserDocView;
import com.example.bellIntegrator.view.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsersDocServiceImpl implements UsersDocService {
    private final UserDocDao dao;
    private final MapperFacade mapperFacade;

    @Autowired
    public UsersDocServiceImpl(UserDocDao dao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    @Transactional
    public void add(UserDocView view) {
        UsersDoc usersDoc = new UsersDoc();
        usersDoc.setUser(view.user);
        usersDoc.setDocCode(view.docCode);
        usersDoc.setDocNumber(view.docNumber);
        usersDoc.setDocDate(view.docDate);
        usersDoc.setIdentified(view.isIdentified);
        dao.save(usersDoc);
    }

    @Override
    @Transactional
    public List<UserDocView> usersDocs() {
        List<UsersDoc> all = dao.all();
        return mapperFacade.mapAsList(all, UserDocView.class);
    }
}
