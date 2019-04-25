package com.example.bellIntegrator.office.dao;

import com.example.bellIntegrator.office.model.Office;
import com.example.bellIntegrator.organization.dao.OrganizationDao;
import com.example.bellIntegrator.organization.dao.OrganizationDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class OfficeDaoImpl implements OfficeDao {

    private final EntityManager em;

    @Autowired
    public OfficeDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Office> findByOrg(Long orgId) {



        return null;
    }

    @Override
    public Office loadById(Long id) {
        return em.find(Office.class, id);
    }

    @Override
    public void save(Office office) {
        OrganizationDao orgDao = new OrganizationDaoImpl(em);
        office.setOrganization(orgDao.loadById(office.getOrganization().getId()));
        em.persist(office);
    }

    @Override
    public void update(Office office) {
        Office of = loadById(office.getId());
        of.setId(office.getId());
        of.setName(office.getName());
        of.setAddress(office.getAddress());
        of.setPhone(office.getPhone());
        of.setActive(true);
        em.merge(of);
    }
}
