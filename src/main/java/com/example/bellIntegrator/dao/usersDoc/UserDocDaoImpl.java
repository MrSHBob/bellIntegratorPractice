package com.example.bellIntegrator.dao.usersDoc;

import com.example.bellIntegrator.model.UsersDoc;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDocDaoImpl implements UserDocDao {

    private final EntityManager em;

    @Autowired
    public UserDocDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<UsersDoc> all() {
        TypedQuery<UsersDoc> query = em.createQuery("SELECT u FROM UsersDoc u", UsersDoc.class);
        return query.getResultList();
    }

    @Override
    public UsersDoc loadById(Long id) {
        return em.find(UsersDoc.class, id);
    }

    @Override
    public void save(UsersDoc userDoc) {
        em.persist(userDoc);
    }
}