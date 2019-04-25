package com.example.bellIntegrator.office.service;

import com.example.bellIntegrator.office.dao.OfficeDao;
import com.example.bellIntegrator.office.model.Office;
import com.example.bellIntegrator.office.view.*;
import com.example.bellIntegrator.organization.model.Organization;
import com.example.bellIntegrator.organization.service.OrganizationService;
import com.example.bellIntegrator.other.mapper.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;

@Service
public class OfficeServiceImpl implements OfficeService {
    private final OfficeDao dao;
    private final MapperFacade mapperFacade;

    @Autowired
    public OfficeServiceImpl(OfficeDao dao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    @Transactional
    public void add(OfficeViewSave view) {
        Office office = new Office();
        Organization org = new Organization();
        org.setId(view.orgId);
        office.setOrganization(org);
        office.setName(view.name);
        office.setAddress(view.address);
        office.setPhone(view.phone);
        office.setActive(view.isActive);
        dao.save(office);
    }

    @Override
    @Transactional
    public void update(@Valid OfficeViewUpdate view) {
        Office office = new Office();
        office.setId(view.id);
        office.setName(view.name);
        office.setAddress(view.address);
        office.setPhone(view.phone);
        office.setActive(view.isActive);
        dao.update(office);

    }

    @Override
    public List<OfficeViewListOut> officeByOrg(Long orgId) {
        List<Office> offices = dao.findByOrg(orgId);
        return mapperFacade.mapAsList(offices, OfficeViewListOut.class);
    }

    @Override
    public OfficeViewGet officeById(Long id) {
        Office office = dao.loadById(id);
        OfficeViewGet view = new OfficeViewGet();
        view.id = office.getId();
        view.name = office.getName();
        view.address = office.getAddress();
        view.phone = office.getPhone();
        view.isActive = office.getActive();
        return view;
    }

}
