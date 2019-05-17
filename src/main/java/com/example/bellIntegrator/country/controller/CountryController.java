package com.example.bellIntegrator.country.controller;

import com.example.bellIntegrator.country.service.CountryService;
import com.example.bellIntegrator.country.view.CountryView;
import com.example.bellIntegrator.country.view.CountryViewSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Контроллер для обработки запросов по Странам
 */
@RestController
@RequestMapping(value = "/api/countries", produces = APPLICATION_JSON_VALUE)
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    /**
     * Метод на запрос списка всех стран
     */
    @GetMapping
    public List<CountryView> countries () {
        List<CountryView> views = countryService.countries();
        return views;
    }

    /**
     * Метод на добавление новой страны в перечень
     */
    @PostMapping("/add")                                                    //temporary method
    public void add (@RequestBody CountryViewSave view) {
        countryService.add(view);
    }
}
