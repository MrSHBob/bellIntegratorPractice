package com.example.bellIntegrator.countrie.service;

import com.example.bellIntegrator.countrie.view.CountrieView;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface CountrieService {

    void add (@Valid CountrieView countrie);

    List<CountrieView> countries();
}
