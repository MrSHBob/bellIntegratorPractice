package com.example.bellIntegrator.countrie.dao;

import com.example.bellIntegrator.countrie.model.Countrie;

import java.util.List;

public interface CountrieDao {

    List<Countrie> all();

    Countrie loadById(Long id);

    Countrie findByCode (Integer code);

    void save(Countrie countrie);
}
