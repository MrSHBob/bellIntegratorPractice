package com.example.bellIntegrator.organization.service;

import com.example.bellIntegrator.organization.model.Organization;
import com.example.bellIntegrator.organization.view.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface OrganizationService {

    void add (@Valid OrganizationViewSave organization);

    void update (@Valid OrganizationViewUpdate view);

    List<OrganizationViewListOut> organizationsByName(String name, String inn);

    OrganizationView organizationsById(Long id);
}
