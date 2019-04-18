package com.example.bellIntegrator.service.office;

import com.example.bellIntegrator.dao.office.OfficeDao;
import com.example.bellIntegrator.model.Office;
import com.example.bellIntegrator.model.mapper.MapperFacade;
import com.example.bellIntegrator.view.OfficeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public void add(OfficeView view) {
        Office office = new Office();
        office.setOrganization(view.org);
        office.setName(view.name);
        office.setAddress(view.address);
        office.setPhone(view.phone);
        office.setActive(view.isActive);
        dao.save(office);
    }

    @Override
    @Transactional
    public List<OfficeView> offices() {
        List<Office> all = dao.all();
        return mapperFacade.mapAsList(all, OfficeView.class);
    }
}
