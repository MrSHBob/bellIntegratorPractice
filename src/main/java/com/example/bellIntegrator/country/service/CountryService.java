package com.example.bellIntegrator.country.service;

import com.example.bellIntegrator.country.view.CountryView;
import com.example.bellIntegrator.country.view.CountryViewSave;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import java.util.List;

/**
 * Интерфейс сервиса страны.
 */
@Validated
public interface CountryService {

    /**
     * Добавление новой страны.
     */
    void add (@Valid CountryViewSave country);

    /**
     * Возвращение списка всех стран.
     */
    List<CountryView> countries();
}
