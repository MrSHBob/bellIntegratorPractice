package com.example.bellIntegrator.organization.service;

import com.example.bellIntegrator.organization.dao.OrganizationDao;
import com.example.bellIntegrator.organization.model.Organization;
import com.example.bellIntegrator.organization.view.*;
import com.example.bellIntegrator.response.mapper.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;

/**
 * Сервис, передающий запросы из контроллера в DAO для организации.
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {
    private final OrganizationDao dao;
    private final MapperFacade mapperFacade;

    @Autowired
    public OrganizationServiceImpl(OrganizationDao dao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
    }

    /**
     * Добавление новой организации.
     */
    @Override
    @Transactional
    public void add(@Valid OrganizationViewSave view) {
        Organization organization = new Organization();
        mapperFacade.map(view, organization);
        organization.setActive(view.isActive);
        dao.save(organization);
    }

    /**
     * Изменение организации.
     */
    @Override
    @Transactional
    public void update(@Valid OrganizationViewUpdate view) {
        Organization organization = dao.loadById(view.id);
        mapperFacade.map(view, organization);
        organization.setActive(view.isActive);
        dao.update(organization);
    }

    /**
     * Фильтр организаций.
     */
    @Override
    public List<OrganizationViewListOut> organizationFilter(@Valid OrganizationViewListIn view) {
        List<Organization> organizations = dao.organizationFilter(view);
        return mapperFacade.mapAsList(organizations, OrganizationViewListOut.class);
    }

    /**
     * Возвращает организацию по id.
     */
    @Override
    public OrganizationView organizationsById(Long id) {
        Organization org = dao.loadById(id);
        OrganizationView view = mapperFacade.map(org, OrganizationView.class);
        view.isActive = org.getActive();
        return view;
    }

}
