package com.example.bellIntegrator.dao.doc;

import com.example.bellIntegrator.model.Doc;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class DocDaoImpl implements DocDao {

    private final EntityManager em;

    @Autowired
    public DocDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Doc> all() {
        TypedQuery<Doc> query = em.createQuery("SELECT d FROM Doc d", Doc.class);
        return query.getResultList();
    }

    @Override
    public Doc loadById(Long id) {
        return em.find(Doc.class, id);
    }

    @Override
    public void save(Doc doc) {
        em.persist(doc);
    }
}
