package com.example.bellIntegrator.country.dao;

import com.example.bellIntegrator.country.model.Country;
import java.util.List;

/**
 * Интерфейс DAO для страны.
 */
public interface CountryDao {

    /**
     * Метод возвращает список всех стран.
     */
    List<Country> all();

    /**
     * Метод возвращает страну по id.
     */
    Country loadById(Long id);

    /**
     * Метод возвращает страну по коду.
     */
    Country findByCode (Integer code);

    /**
     * Метод добавляет новую запись в таблицу "country".
     */
    void save(Country country);
}
