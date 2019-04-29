package com.example.bellIntegrator.organization.service;

import com.example.bellIntegrator.organization.dao.OrganizationDao;
import com.example.bellIntegrator.organization.model.Organization;
import com.example.bellIntegrator.organization.view.*;
import com.example.bellIntegrator.other.mapper.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
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
    public void add(@Valid OrganizationViewSave view) {
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
    public void update(@Valid OrganizationViewUpdate view) {
        Organization organization = dao.loadById(view.id);
        organization.setName(view.name);
        organization.setFullName(view.fullName);
        organization.setInn(view.inn);
        organization.setKpp(view.kpp);
        organization.setAddress(view.address);
        organization.setPhone(view.phone);
        organization.setActive(view.isActive);
        dao.update(organization);
    }

    @Override
    public List<OrganizationViewListOut> organizationsByName(String name, String inn) {
        List<Organization> organizations = dao.loadByName(name, inn);
        return mapperFacade.mapAsList(organizations, OrganizationViewListOut.class);
    }

    @Override
    public OrganizationView organizationsById(Long id) {
        Organization org = dao.loadById(id);
        OrganizationView view = new OrganizationView();
        view.id = org.getId();
        view.name = org.getName();
        view.fullName = org.getFullName();
        view.inn = org.getInn();
        view.kpp = org.getKpp();
        view.address = org.getAddress();
        view.phone = org.getPhone();
        view.isActive = org.getActive();
        return view;
    }

}
