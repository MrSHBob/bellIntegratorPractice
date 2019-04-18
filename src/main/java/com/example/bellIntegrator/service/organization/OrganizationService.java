package com.example.bellIntegrator.service.organization;

import com.example.bellIntegrator.view.OrganizationView;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface OrganizationService {

    void add (@Valid OrganizationView organization);

    List<OrganizationView> organizations();
}
