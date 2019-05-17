package com.example.bellIntegrator.country.dao;

import com.example.bellIntegrator.country.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * DAO для страны.
 */
@Repository
public class CountryDaoImpl implements CountryDao {

    private final EntityManager em;

    @Autowired
    public CountryDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * Метод возвращает список всех стран.
     */
    @Override
    public List<Country> all() {
        TypedQuery<Country> query = em.createQuery("SELECT c FROM Countrie c", Country.class);
        return query.getResultList();
    }

    /**
     * Метод возвращает страну по id.
     */
    @Override
    public Country loadById(Long id) {
        return em.find(Country.class, id);
    }

    /**
     * Метод возвращает страну по коду.
     */
    @Override
    public Country findByCode(Integer code) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Country> criteriaQuery = criteriaBuilder.createQuery(Country.class);
        Root<Country> countrie = criteriaQuery.from(Country.class);
        Predicate predicate = criteriaBuilder.equal(countrie.get("code"),code);
        criteriaQuery.select(countrie).where(predicate);
        TypedQuery<Country> query = em.createQuery(criteriaQuery);
        return query.getSingleResult();
    }

    /**
     * Метод добавляет новую запись в таблицу "country".
     */
    @Override
    public void save(Country country) {
        em.persist(country);
    }
}
