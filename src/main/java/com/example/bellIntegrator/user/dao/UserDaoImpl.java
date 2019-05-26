package com.example.bellIntegrator.user.dao;

import com.example.bellIntegrator.country.dao.CountryDaoImpl;
import com.example.bellIntegrator.user.model.User;
import com.example.bellIntegrator.user.view.UserViewListIn;
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
 * DAO для юзера.
 */
@Repository
public class UserDaoImpl implements UserDao {

    private final EntityManager em;
    private final CountryDaoImpl countryDao;

    @Autowired
    public UserDaoImpl(EntityManager em, CountryDaoImpl countryDao) {
        this.em = em;
        this.countryDao = countryDao;
    }

    /**
     * Метод возвращает юзера по id.
     */
    @Override
    public User loadById(Long id) {
        return em.find(User.class, id);
    }

    /**
     * Метод добавляет новую запись в таблицу "user".
     */
    @Override
    public void save(User user) {
        em.persist(user);
    }

    /**
     * Метод изменяет существующего юзера.
     */
    @Override
    public void update(User user) {
        em.merge(user);
    }

    /**
     * Фильтр юзеров по id офиса и др. полям.
     */
    @Override
    public List<User> userFilter(UserViewListIn view) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> user = criteriaQuery.from(User.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(criteriaBuilder.equal(user.get("office"),view.officeId));
        if (view.firstName.length() > 0) {
            predicates.add(criteriaBuilder.equal(user.get("firstName"), view.firstName));
        }
        if (view.secondName != null && view.secondName.length() > 0) {
            predicates.add(criteriaBuilder.equal(user.get("secondName"), view.secondName));
        }
        if (view.middleName != null && view.middleName.length() > 0) {
            predicates.add(criteriaBuilder.equal(user.get("middleName"), view.middleName));
        }
        if (view.position != null && view.position.length() > 0) {
            predicates.add(criteriaBuilder.equal(user.get("position"), view.position));
        }
// first way of query
        if (view.docCod != null) {
            predicates.add(criteriaBuilder.equal(user.get("userDoc").get("doc").get("code"), view.docCod));
        }
//second way of query, which better?
        if (view.citizenshipCode != null) {
            predicates.add(criteriaBuilder.equal(user.get("citizenship"), countryDao.findByCode(view.citizenshipCode)));
        }
        criteriaQuery.select(user).where(predicates.toArray(new Predicate[] {}));
        TypedQuery<User> query = em.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
