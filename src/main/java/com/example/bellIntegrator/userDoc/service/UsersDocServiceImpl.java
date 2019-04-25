package com.example.bellIntegrator.userDoc.service;

import com.example.bellIntegrator.userDoc.dao.UserDocDao;
import com.example.bellIntegrator.userDoc.model.UsersDoc;
import com.example.bellIntegrator.other.mapper.MapperFacade;
import com.example.bellIntegrator.userDoc.view.UserDocView;
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
        usersDoc.setDoc(view.doc);
        usersDoc.setDocNumber(view.docNumber);
        usersDoc.setDocDate(view.docDate);
        dao.save(usersDoc);
    }

    @Override
    @Transactional
    public List<UserDocView> usersDocs() {
        List<UsersDoc> all = dao.all();
        return mapperFacade.mapAsList(all, UserDocView.class);
    }
}
