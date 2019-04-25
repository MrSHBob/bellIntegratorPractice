package com.example.bellIntegrator.organization.controller;

import com.example.bellIntegrator.organization.model.Organization;
import com.example.bellIntegrator.organization.service.OrganizationService;
import com.example.bellIntegrator.organization.view.*;
import com.example.bellIntegrator.other.view.DataView;
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

    @PostMapping("/list")                 //Нет данных в базе... почему?
    public String list (@RequestBody OrganizationViewListIn orgView) {
        List<OrganizationViewListOut> orgViews = organizationService.organizationsByName(orgView.name);
        DataView dataView = new DataView();
        dataView.data = orgViews.toString();
        return dataView.toString();
    }

    @RequestMapping(value = "/{id:[\\d]+}", method = GET)
    public String orgById (@PathVariable("id") Long orgId) {
        OrganizationView orgView = organizationService.organizationsById(orgId);
        DataView dataView = new DataView();
        dataView.data = orgView.toString();
        return dataView.toString();
    }

    @PostMapping("/update")
    public String update(@RequestBody OrganizationViewUpdate view) {                //do not work! it is just like save((
        organizationService.update(view);
        DataView dataView = new DataView();
        dataView.data = "{result:success}";
        return  dataView.toString();
    }

    @PostMapping("/save")
    public String save(@RequestBody OrganizationViewSave view) {
        organizationService.add(view);
        DataView dataView = new DataView();
        dataView.data = "{result:success}";
        return  dataView.toString();
    }
}
