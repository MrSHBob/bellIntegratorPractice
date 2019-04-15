package com.example.bellIntegrator.dao.countrie;

import com.example.bellIntegrator.model.Countrie;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

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
    public void save(Countrie countrie) {
        em.persist(countrie);
    }
}
