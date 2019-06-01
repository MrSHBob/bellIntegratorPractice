package com.example.bellIntegrator.organization.dao;

import com.example.bellIntegrator.organization.model.Organization;
import com.example.bellIntegrator.organization.view.OrganizationViewListIn;
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
 * DAO для организации.
 */
@Repository
public class OrganizationDaoImpl implements OrganizationDao {
    private final EntityManager em;

    @Autowired
    public OrganizationDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * Метод возвращает организацию по id.
     */
    @Override
    public Organization loadById(Long id) {
        return em.find(Organization.class, id);
    }

    /**
     * Фильтр организаций по частичному вхождению по имени, и по ИНН.
     */
    @Override
    public List<Organization> organizationFilter( OrganizationViewListIn view) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Organization> criteriaQuery = criteriaBuilder.createQuery(Organization.class);
        Root<Organization> organization = criteriaQuery.from(Organization.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(criteriaBuilder.like(organization.get("name"),"%" + view.name + "%"));
        if (view.inn != null && view.inn.length() > 0) {
            predicates.add(criteriaBuilder.equal(organization.get("inn"),view.inn));
        }
        criteriaQuery.where(predicates.toArray(new Predicate[] {}));
        criteriaQuery.select(organization);
        TypedQuery<Organization> query = em.createQuery(criteriaQuery);
        return query.getResultList();
    }

    /**
     * Метод добавляет новую запись в таблицу "organization".
     */
    @Override
    public void save(Organization organization) {
        em.persist(organization);
    }

    /**
     * Изменение существующей организации.
     */
    @Override
    public void update(Organization organization) {
        em.merge(organization);
    }

}
