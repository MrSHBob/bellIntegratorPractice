package com.example.bellIntegrator.user.userDoc.dao;

import com.example.bellIntegrator.user.userDoc.model.UsersDoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * DAO для документа юзера.
 */
@Repository
public class UserDocDaoImpl implements UserDocDao {
    private final EntityManager em;

    @Autowired
    public UserDocDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * Возвращение всех документов всех юзеров.
     */
    @Override
    public List<UsersDoc> all() {
        TypedQuery<UsersDoc> query = em.createQuery("SELECT u FROM UsersDoc u", UsersDoc.class);
        return query.getResultList();
    }

    /**
     * Возвращение по id документа юзера.
     */
    @Override
    public UsersDoc loadById(Long id) {
        return em.find(UsersDoc.class, id);
    }

    /**
     * Добавление нового документа юзера.
     */
    @Override
    public void save(UsersDoc userDoc) {
        em.persist(userDoc);
    }
}
