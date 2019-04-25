package com.example.bellIntegrator.organization.dao;

import com.example.bellIntegrator.organization.model.Organization;

import java.util.List;

public interface OrganizationDao {

    Organization loadById(Long id);

    List<Organization> loadByName(String name);

    void save(Organization organization);

    void update(Organization organization);
}
