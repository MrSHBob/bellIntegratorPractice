package com.example.bellIntegrator.office.controller;

import com.example.bellIntegrator.office.service.OfficeService;
import com.example.bellIntegrator.office.view.*;
import com.example.bellIntegrator.other.view.DataView;
import com.example.bellIntegrator.other.view.ErrorView;
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
    public String list (@RequestBody OfficeViewListIn view) {
        List<OfficeViewListOut> views = officeService.officeByOrg(view.orgId);
        DataView dataView = new DataView();
        dataView.data = views.toString();
        return dataView.toString();
    }

    @RequestMapping(value = "/{id:[\\d]+}", method = GET)
    public String officeById (@PathVariable("id") Long id) {
        OfficeViewGet view = officeService.officeById(id);
        DataView dataView = new DataView();
        dataView.data = view.toString();
        return dataView.toString();
    }

    @PostMapping("/update")
    public String update(@RequestBody OfficeViewUpdate view) {
        officeService.update(view);
        DataView dataView = new DataView();
        dataView.data = "{result:success}";
        return  dataView.toString();
    }

    @PostMapping("/save")
    public String save(@RequestBody OfficeViewSave view) {
        officeService.add(view);
        DataView dataView = new DataView();
        dataView.data = "{result:success}";
        return  dataView.toString();
    }
}
