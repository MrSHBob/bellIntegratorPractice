package com.example.bellIntegrator.service.countrie;

import com.example.bellIntegrator.dao.countrie.CountrieDao;
import com.example.bellIntegrator.model.Countrie;
import com.example.bellIntegrator.model.mapper.MapperFacade;
import com.example.bellIntegrator.view.CountrieView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CountrieServiceImpl implements CountrieService {
    private final CountrieDao dao;
    private final MapperFacade mapperFacade;

    @Autowired
    public CountrieServiceImpl(CountrieDao dao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    @Transactional
    public void add(CountrieView view) {
        Countrie countrie = new Countrie();
        countrie.setCode(view.code);
        countrie.setName(view.name);
        dao.save(countrie);
    }

    @Override
    @Transactional
    public List<CountrieView> countries() {
        List<Countrie> all = dao.all();
        return mapperFacade.mapAsList(all, CountrieView.class);
    }
}
