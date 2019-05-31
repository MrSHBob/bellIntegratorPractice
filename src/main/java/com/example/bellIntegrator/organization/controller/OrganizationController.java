package com.example.bellIntegrator.organization.controller;

import com.example.bellIntegrator.response.view.SuccessView;
import com.example.bellIntegrator.organization.service.OrganizationService;
import com.example.bellIntegrator.organization.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Контроллер для обработки запросов по Организациям
 */
@RestController
@RequestMapping(value = "/api/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    /**
     * Фильтр организаций по частичному вхождению имени
     */
    @PostMapping("/list")
    public List<OrganizationViewListOut> list (@RequestBody OrganizationViewListIn view) {
        List<OrganizationViewListOut> orgViews = organizationService.organizationFilter(view);
        return orgViews;
    }

    /**
     * Запрос организации по идентификатору
     */
    @RequestMapping(value = "/{id:[\\d]+}", method = GET)
    public OrganizationView orgById (@PathVariable("id") Long orgId) {
        OrganizationView orgView = organizationService.organizationsById(orgId);
        return orgView;
    }

    /**
     * Изменение существующей организации
     */
    @PostMapping("/update")
    public void update(@RequestBody OrganizationViewUpdate view) {
        organizationService.update(view);
    }

    /**
     * Добавление новой организации
     */
    @PostMapping("/save")
    public void save(@RequestBody OrganizationViewSave view) {
        organizationService.add(view);
    }

}
