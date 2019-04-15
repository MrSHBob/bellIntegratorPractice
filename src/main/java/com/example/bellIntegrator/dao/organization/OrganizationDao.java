package com.example.bellIntegrator.dao.organization;

import com.example.bellIntegrator.model.Office;
import com.example.bellIntegrator.model.Organization;

import java.util.List;

public interface OrganizationDao {

    List<Organization> all();

    Organization loadById(Long id);

    void save(Organization organization);
}