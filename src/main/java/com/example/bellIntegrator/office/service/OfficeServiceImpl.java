package com.example.bellIntegrator.office.service;

import com.example.bellIntegrator.office.dao.OfficeDao;
import com.example.bellIntegrator.office.model.Office;
import com.example.bellIntegrator.office.view.*;
import com.example.bellIntegrator.organization.dao.OrganizationDao;
import com.example.bellIntegrator.response.mapper.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;

/**
 * Сервис, передающий запросы из контроллера в DAO для офиса.
 */
@Service
public class OfficeServiceImpl implements OfficeService {
    private final OfficeDao dao;
    private final MapperFacade mapperFacade;
    private final OrganizationDao orgDao;

    @Autowired
    public OfficeServiceImpl(OfficeDao dao, MapperFacade mapperFacade, OrganizationDao orgDao) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
        this.orgDao = orgDao;
    }

    /**
     * Добавление нового офиса.
     */
    @Override
    @Transactional
    public void add(OfficeViewSave view) {
        Office office = new Office();
        mapperFacade.map(view, office);
        office.setOrganization(orgDao.loadById(view.orgId));
        office.setActive(view.isActive);
        dao.save(office);
    }

    /**
     * Изменение офиса.
     */
    @Override
    @Transactional
    public void update(@Valid OfficeViewUpdate view) {
        Office office = dao.loadById(view.id);
        mapperFacade.map(view, office);
        office.setActive(view.isActive);
        dao.update(office);
    }

    /**
     * Фильтр офисов по организации и др. полям.
     */
    @Override
    public List<OfficeViewListOut> officeFilter(OfficeViewListIn view) {
        List<Office> offices = dao.officeFilter(view);
        return mapperFacade.mapAsList(offices, OfficeViewListOut.class);
    }

    /**
     * Возвращает офис по id.
     */
    @Override
    public OfficeViewGet officeById(Long id) {
        Office office = dao.loadById(id);
        OfficeViewGet view = mapperFacade.map(office, OfficeViewGet.class);
        view.isActive = office.getActive();
        return view;
    }

}
