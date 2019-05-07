package com.example.bellIntegrator.countrie.controller;

import com.example.bellIntegrator.additionalLogic.view.SuccessView;
import com.example.bellIntegrator.countrie.service.CountrieService;
import com.example.bellIntegrator.countrie.view.CountrieView;
import com.example.bellIntegrator.countrie.view.CountrieViewSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/countries", produces = APPLICATION_JSON_VALUE)
public class CountrieController {

    private final CountrieService countrieService;

    @Autowired
    public CountrieController (CountrieService countrieService) {
        this.countrieService = countrieService;
    }

    @GetMapping
    public List<CountrieView> countries () {
        List<CountrieView> views = countrieService.countries();
        return views;
    }

    @PostMapping("/add")                                                    //temporary method
    public SuccessView add (@RequestBody CountrieViewSave view) {
        countrieService.add(view);
        SuccessView success = new SuccessView();
        return  success;
    }
}
