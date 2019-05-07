package com.example.bellIntegrator.office.controller;

import com.example.bellIntegrator.additionalLogic.view.SuccessView;
import com.example.bellIntegrator.office.service.OfficeService;
import com.example.bellIntegrator.office.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/api/office", produces = APPLICATION_JSON_VALUE)
public class OfficeController {

    private final OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @PostMapping("/list")
    public List<OfficeViewListOut> list (@RequestBody OfficeViewListIn view) {
        List<OfficeViewListOut> views = officeService.officeByOrg(view.orgId);
        return views;
    }

    @RequestMapping(value = "/{id:[\\d]+}", method = GET)
    public OfficeViewGet officeById (@PathVariable("id") Long id) {
        OfficeViewGet view = officeService.officeById(id);
        return view;
    }

    @PostMapping("/update")
    public SuccessView update(@RequestBody OfficeViewUpdate view) {
        officeService.update(view);
        SuccessView success = new SuccessView();
        return  success;
    }

    @PostMapping("/save")
    public SuccessView save(@RequestBody OfficeViewSave view) {
        officeService.add(view);
        SuccessView success = new SuccessView();
        return  success;
    }
}
