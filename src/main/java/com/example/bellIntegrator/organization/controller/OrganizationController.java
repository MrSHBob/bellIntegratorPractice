package com.example.bellIntegrator.organization.controller;

import com.example.bellIntegrator.additionalLogic.view.SuccessView;
import com.example.bellIntegrator.organization.service.OrganizationService;
import com.example.bellIntegrator.organization.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/api/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @PostMapping("/list")
    public List<OrganizationViewListOut> list (@RequestBody OrganizationViewListIn view) {
        List<OrganizationViewListOut> orgViews = organizationService.organizationsByName(view.name, view.inn);
        return orgViews;
    }

    @RequestMapping(value = "/{id:[\\d]+}", method = GET)
    public OrganizationView orgById (@PathVariable("id") Long orgId) {
        OrganizationView orgView = organizationService.organizationsById(orgId);
        return orgView;
    }

    @PostMapping("/update")
    public SuccessView update(@RequestBody OrganizationViewUpdate view) {
        organizationService.update(view);
        SuccessView success = new SuccessView();
        return  success;
    }

    @PostMapping("/save")
    public SuccessView save(@RequestBody OrganizationViewSave view) {
        organizationService.add(view);
        SuccessView success = new SuccessView();
        return  success;
    }

}
