package com.example.bellIntegrator.user.service;

import com.example.bellIntegrator.country.dao.CountryDao;
import com.example.bellIntegrator.doc.dao.DocDao;
import com.example.bellIntegrator.doc.model.Doc;
import com.example.bellIntegrator.office.dao.OfficeDao;
import com.example.bellIntegrator.user.dao.UserDao;
import com.example.bellIntegrator.user.model.User;
import com.example.bellIntegrator.response.mapper.MapperFacade;
import com.example.bellIntegrator.user.userDoc.model.UsersDoc;
import com.example.bellIntegrator.user.view.UserViewGet;
import com.example.bellIntegrator.user.view.UserViewListIn;
import com.example.bellIntegrator.user.view.UserViewListOut;
import com.example.bellIntegrator.user.view.UserViewSave;
import com.example.bellIntegrator.user.view.UserViewUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.validation.Valid;
import java.util.List;

/**
 * Сервис для юзера.
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserDao dao;
    private final MapperFacade mapperFacade;
    private final OfficeDao officeDao;
    private final DocDao docDao;
    private final CountryDao countryDao;

    @Autowired
    public UserServiceImpl(
            UserDao dao, MapperFacade mapperFacade, OfficeDao officeDao, DocDao docDao, CountryDao countryDao
    ) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
        this.officeDao = officeDao;
        this.docDao = docDao;
        this.countryDao = countryDao;
    }

    /**
     * Добавление нового юзера.
     */
    @Override
    @Transactional
    public void add(UserViewSave view) {
        User user = mapperFacade.map(view, User.class);
        user.setOffice(officeDao.loadById(view.officeId));
        UsersDoc usersDoc = new UsersDoc();
        if (view.docCode != null && view.docCode > 0) {
            usersDoc.setUser(user);
            Doc doc = docDao.findByCode(view.docCode);
            usersDoc.setDoc(doc);
            usersDoc.setDocNumber(view.docNumber);
            usersDoc.setDocDate(view.docDate);
            user.setUserDoc(usersDoc);
        } else if (view.docName != null && view.docName.length() != 0) {
            Doc doc = docDao.findByName(view.docName);
            usersDoc.setUser(user);
            usersDoc.setDoc(doc);
            usersDoc.setDocNumber(view.docNumber);
            usersDoc.setDocDate(view.docDate);
            user.setUserDoc(usersDoc);
        }
        if (view.citizenshipCode != null && view.citizenshipCode > 0) {
            user.setCitizenship(countryDao.findByCode(view.citizenshipCode));
        }
        user.setIdentified(view.isIdentified);
        dao.save(user);
    }

    /**
     * Изменение юзера.
     */
    @Override
    @Transactional
    public void update(UserViewUpdate view) {
        User user = dao.loadById(view.id);
        if (view.officeId != null && view.officeId != 0) {
            user.setOffice(officeDao.loadById(view.officeId));
        }
        mapperFacade.map(view, user);
        // тут мы сэтим документ
        if (view.docName != null && view.docName.length() != 0) {
            if (user.getUserDoc() != null) {
                user.getUserDoc().setDocNumber(view.docNumber);
                user.getUserDoc().setDocDate(view.docDate);
            } else {
                UsersDoc userDoc = new UsersDoc();
                Doc doc;
                try {
                    doc= docDao.findByName(view.docName);
                    if (doc != null) {
                        userDoc.setDoc(doc);
                        userDoc.setDocNumber(view.docNumber);
                        userDoc.setDocDate(view.docDate);
                        userDoc.setUser(user);
                        user.setUserDoc(userDoc);
                    }
                } catch (Exception e) {
                    throw new RuntimeException("wrong docName");
                }
            }
        }
        if (view.citizenshipCode != null && view.citizenshipCode > 0) {
            user.setCitizenship(countryDao.findByCode(view.citizenshipCode));
        }
        user.setIdentified(view.isIdentified);
        dao.update(user);
    }

    /**
     * Фильтр юзеров.
     */
    @Override
    public List<UserViewListOut> userFilter(@Valid UserViewListIn view) {
        List<User> users = dao.userFilter(view);
        return mapperFacade.mapAsList(users, UserViewListOut.class);
    }

    /**
     * Возвращает юзера по id.
     */
    @Override
    public UserViewGet userById(Long id) {
        User user = dao.loadById(id);
        if (user == null) {
            throw new NullPointerException();
        }
        UserViewGet view = new UserViewGet();
        mapperFacade.map(user, view);
        if (user.getUserDoc() != null) {
            view.docName = user.getUserDoc().getDoc().getName();
            view.docNumber = user.getUserDoc().getDocNumber();
            view.docDate = user.getUserDoc().getDocDate();
        }
        if (user.getCitizenship() != null) {
            view.citizenshipName = user.getCitizenship().getName();
            view.citizenshipCode = user.getCitizenship().getCode();
        }
        view.isIdentified = user.getIdentified();

        return view;
    }
}
