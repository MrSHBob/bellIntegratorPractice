package com.example.bellIntegrator.countrie.dao;

import com.example.bellIntegrator.countrie.model.Countrie;
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
public class CountrieDaoImpl implements CountrieDao {

    private final EntityManager em;

    @Autowired
    public CountrieDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Countrie> all() {
        TypedQuery<Countrie> query = em.createQuery("SELECT c FROM Countrie c", Countrie.class);
        return query.getResultList();
    }

    @Override
    public Countrie loadById(Long id) {
        return em.find(Countrie.class, id);
    }

    @Override
    public Countrie findByCode(Integer code) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Countrie> criteriaQuery = criteriaBuilder.createQuery(Countrie.class);
        Root<Countrie> countrie = criteriaQuery.from(Countrie.class);
        Predicate predicate = criteriaBuilder.equal(countrie.get("code"),code);
        criteriaQuery.select(countrie).where(predicate);
        TypedQuery<Countrie> query = em.createQuery(criteriaQuery);
        return query.getSingleResult();
    }

    @Override
    public void save(Countrie countrie) {
        em.persist(countrie);
    }


}
