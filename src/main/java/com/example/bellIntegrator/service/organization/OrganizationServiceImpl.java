package com.example.bellIntegrator.service.organization;

import com.example.bellIntegrator.dao.organization.OrganizationDao;
import com.example.bellIntegrator.model.Organization;
import com.example.bellIntegrator.model.mapper.MapperFacade;
import com.example.bellIntegrator.view.OrganizationView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {
    private final OrganizationDao dao;
    private final MapperFacade mapperFacade;

    @Autowired
    public OrganizationServiceImpl(OrganizationDao dao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    @Transactional
    public void add(OrganizationView view) {
        Organization organization = new Organization();
        organization.setName(view.name);
        organization.setFullName(view.fullName);
        organization.setInn(view.inn);
        organization.setKpp(view.kpp);
        organization.setAddress(view.address);
        organization.setPhone(view.phone);
        organization.setActive(view.isActive);
        dao.save(organization);
    }

    @Override
    @Transactional
    public List<OrganizationView> organizations() {
        List<Organization> all = dao.all();
        return mapperFacade.mapAsList(all, OrganizationView.class);
    }

    @Override
    @Transactional
    public List<OrganizationView> organizationsByName(String name) {
        List<Organization> organizations = dao.loadByName(name);
        return mapperFacade.mapAsList(organizations, OrganizationView.class);
    }
}
