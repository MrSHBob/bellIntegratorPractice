package com.example.bellIntegrator.country.service;

import com.example.bellIntegrator.country.dao.CountryDao;
import com.example.bellIntegrator.country.model.Country;
import com.example.bellIntegrator.country.view.CountryViewSave;
import com.example.bellIntegrator.response.mapper.MapperFacade;
import com.example.bellIntegrator.country.view.CountryView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Сервис для страны.
 */
@Service
public class CountryServiceImpl implements CountryService {
    private final CountryDao dao;
    private final MapperFacade mapperFacade;

    @Autowired
    public CountryServiceImpl(CountryDao dao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
    }

    /**
     * Добавление новой страны.
     */
    @Override
    @Transactional
    public void add(CountryViewSave view) {
        Country country = new Country();
        country.setCode(view.code);
        country.setName(view.name);
        dao.save(country);
    }

    /**
     * Возвращение списка всех стран.
     */
    @Override
    public List<CountryView> countries() {
        List<Country> all = dao.all();
        return mapperFacade.mapAsList(all, CountryView.class);
    }
}
