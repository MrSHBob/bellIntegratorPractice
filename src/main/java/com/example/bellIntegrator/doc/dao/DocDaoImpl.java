package com.example.bellIntegrator.doc.dao;

import com.example.bellIntegrator.doc.model.Doc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
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

    @Override
    public Doc findByName(String name) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Doc> criteriaQuery = criteriaBuilder.createQuery(Doc.class);
        Root<Doc> doc = criteriaQuery.from(Doc.class);
        Predicate predicate = criteriaBuilder.equal(doc.get("name"),name);
        criteriaQuery.select(doc).where(predicate);
        TypedQuery<Doc> query = em.createQuery(criteriaQuery);
        return query.getSingleResult();
    }

    @Override
    public Doc findByCode(Integer code) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Doc> criteriaQuery = criteriaBuilder.createQuery(Doc.class);
        Root<Doc> doc = criteriaQuery.from(Doc.class);
        Predicate predicate = criteriaBuilder.equal(doc.get("code"),code);
        criteriaQuery.select(doc).where(predicate);
        TypedQuery<Doc> query = em.createQuery(criteriaQuery);
        return query.getSingleResult();
    }
}
