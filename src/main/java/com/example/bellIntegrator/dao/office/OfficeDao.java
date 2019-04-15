package com.example.bellIntegrator.dao.office;

import com.example.bellIntegrator.model.Office;

import java.util.List;

public interface OfficeDao {

    List<Office> all();

    Office loadById(Long id);

    void save(Office office);
}
