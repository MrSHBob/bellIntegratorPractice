package com.example.bellIntegrator.service.countrie;

import com.example.bellIntegrator.view.CountrieView;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface CountrieService {

    void add (@Valid CountrieView countrie);

    List<CountrieView> countries();
}
