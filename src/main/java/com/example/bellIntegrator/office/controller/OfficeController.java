package com.example.bellIntegrator.office.controller;

import com.example.bellIntegrator.office.service.OfficeService;
import com.example.bellIntegrator.office.view.OfficeViewGet;
import com.example.bellIntegrator.office.view.OfficeViewListIn;
import com.example.bellIntegrator.office.view.OfficeViewListOut;
import com.example.bellIntegrator.office.view.OfficeViewSave;
import com.example.bellIntegrator.office.view.OfficeViewUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Контроллер для обработки запросов по Офисам
 */
@RestController
@RequestMapping(value = "/api/office", produces = APPLICATION_JSON_VALUE)
public class OfficeController {

    private final OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    /**
     * Фильтр офисов по организации
     */
    @PostMapping("/list")
    public List<OfficeViewListOut> officeFilter (@RequestBody OfficeViewListIn view) {
        List<OfficeViewListOut> views = officeService.officeFilter(view);
        return views;
    }

    /**
     * Запрос офиса по идентификатору
     */
    @RequestMapping(value = "/{id:[\\d]+}", method = GET)
    public OfficeViewGet officeById (@PathVariable("id") Long id) {
        OfficeViewGet view = officeService.officeById(id);
        return view;
    }

    /**
     * Изменение существующего офиса
     */
    @PostMapping("/update")
    public void update(@RequestBody OfficeViewUpdate view) {
        officeService.update(view);
    }

    /**
     * Добавление нового офиса
     */
    @PostMapping("/save")
    public void save(@RequestBody OfficeViewSave view) {
        officeService.add(view);
    }
}
