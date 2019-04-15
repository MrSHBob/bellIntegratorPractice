package com.example.bellIntegrator.dao.countrie;

import com.example.bellIntegrator.model.Countrie;

import java.util.List;

public interface CountrieDao {

    List<Countrie> all();

    Countrie loadById(Long id);

    void save(Countrie countrie);
}
