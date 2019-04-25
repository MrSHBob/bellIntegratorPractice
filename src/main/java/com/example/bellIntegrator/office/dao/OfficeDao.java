package com.example.bellIntegrator.office.dao;

import com.example.bellIntegrator.office.model.Office;

import java.util.List;

public interface OfficeDao {

    List<Office> findByOrg(Long orgId);

    Office loadById(Long id);

    void save(Office office);

    void update(Office office);
}
