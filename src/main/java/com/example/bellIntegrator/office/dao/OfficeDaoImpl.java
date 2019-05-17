package com.example.bellIntegrator.office.dao;

import com.example.bellIntegrator.office.model.Office;
import com.example.bellIntegrator.office.view.OfficeViewListIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO для офиса.
 */
@Repository
public class OfficeDaoImpl implements OfficeDao {

    private final EntityManager em;

    @Autowired
    public OfficeDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * Фильтр офисов по id организации и др. полям.
     */
    @Override
    public List<Office> officeFilter(OfficeViewListIn view) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Office> criteriaQuery = criteriaBuilder.createQuery(Office.class);
        Root<Office> office = criteriaQuery.from(Office.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(criteriaBuilder.equal(office.get("organization"), view.orgId));
        if (view.name.length() > 0) {
            predicates.add(criteriaBuilder.equal(office.get("name"), view.name));
        }
        if (view.phone.length() > 0) {
            predicates.add(criteriaBuilder.equal(office.get("phone"), view.phone));
        }
        criteriaQuery.where(predicates.toArray(new Predicate[]{}));
        criteriaQuery.select(office);
        TypedQuery<Office> query = em.createQuery(criteriaQuery);
        return query.getResultList();
    }

    /**
     * Метод возвращает офис по id.
     */
    @Override
    public Office loadById(Long id) {
        return em.find(Office.class, id);
    }

    /**
     * Метод добавляет новую запись в таблицу "office".
     */
    @Override
    public void save(Office office) {
        em.persist(office);
    }

    /**
     * Метод изменяет существующий офис.
     */
    @Override
    public void update(Office office) {
        em.merge(office);
    }
}
