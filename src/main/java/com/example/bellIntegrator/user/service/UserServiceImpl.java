package com.example.bellIntegrator.user.service;

import com.example.bellIntegrator.countrie.dao.CountrieDao;
import com.example.bellIntegrator.countrie.model.Countrie;
import com.example.bellIntegrator.doc.dao.DocDao;
import com.example.bellIntegrator.doc.model.Doc;
import com.example.bellIntegrator.office.dao.OfficeDao;
import com.example.bellIntegrator.office.model.Office;
import com.example.bellIntegrator.office.view.OfficeViewListOut;
import com.example.bellIntegrator.user.dao.UserDao;
import com.example.bellIntegrator.user.model.User;
import com.example.bellIntegrator.other.mapper.MapperFacade;
import com.example.bellIntegrator.user.view.*;
import com.example.bellIntegrator.userDoc.model.UsersDoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao dao;
    private final MapperFacade mapperFacade;
    private final OfficeDao officeDao;
    private final DocDao docDao;
    private final CountrieDao countrieDao;

    @Autowired
    public UserServiceImpl(
            UserDao dao, MapperFacade mapperFacade, OfficeDao officeDao, DocDao docDao, CountrieDao countrieDao
    ) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
        this.officeDao = officeDao;
        this.docDao = docDao;
        this.countrieDao = countrieDao;
    }

    @Override
    @Transactional
    public void add(UserViewSave view) {
        User user = new User();
        user.setOffice(officeDao.loadById(view.officeId));
        user.setFirstName(view.firstName);
        user.setSecondName(view.secondName);
        user.setMiddleName(view.middleName);
        user.setPosition(view.position);
        user.setPhone(view.phone);

        UsersDoc usersDoc = new UsersDoc();
        usersDoc.setUser(user);

        if (view.docCode != null && view.docCode > 0) {
            Doc doc = docDao.findByCode(view.docCode);
            usersDoc.setDoc(doc);
            usersDoc.setDocNumber(view.docNumber);
            usersDoc.setDocDate(view.docDate);
            user.setUserDoc(usersDoc);
        } else if (view.docName != null && view.docName.length() != 0) {
            Doc doc = docDao.findByName(view.docName);
            usersDoc.setDoc(doc);
            usersDoc.setDocNumber(view.docNumber);
            usersDoc.setDocDate(view.docDate);
            user.setUserDoc(usersDoc);
        }

        if (view.citizenshipCode != null && view.citizenshipCode > 0) {
            user.setCitizenship(countrieDao.findByCode(view.citizenshipCode));
        }

        user.setIdentified(view.isIdentified);
        dao.save(user);
    }

    @Override
    @Transactional
    public void update(UserViewUpdate view) {
        User user = dao.loadById(view.id);
        if (view.officeId != null && view.officeId != 0) {
            user.setOffice(officeDao.loadById(view.officeId));
        }
        user.setFirstName(view.firstName);
        user.setSecondName(view.secondName);
        user.setMiddleName(view.middleName);
        user.setPosition(view.position);
        user.setPhone(view.phone);

        // тут мы сэтим документ
        //user.getUserDoc().setDocNumber(view.docNumber);

        // еще мы сэтим гражданство
        user.setCitizenship(countrieDao.findByCode(view.citizenshipCode));

        user.setIdentified(view.isIdentified);
        dao.update(user);
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
        view.id = user.getId();
        view.firstName = user.getFirstName();
        view.secondName = user.getSecondName();
        view.middleName = user.getMiddleName();
        view.position = user.getPosition();
        view.phone = user.getPhone();

//        view.docName = user.;
//        view.docNumber = user.;
//        view.docDate = user.;
//        view.citizenshipName = user.;
//        view.citizenshipCode = user.;

        view.isIdentified = user.getIdentified();

        return null;
    }
}
