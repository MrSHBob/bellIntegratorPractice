package com.example.bellIntegrator.office.dao;

import com.example.bellIntegrator.office.model.Office;
import com.example.bellIntegrator.office.view.OfficeViewListIn;
import java.util.List;

/**
 * Интерфейс DAO для офиса.
 */
public interface OfficeDao {

    /**
     * Фильтр офисов по id организации и др. полям.
     */
    List<Office> officeFilter(OfficeViewListIn view);

    /**
     * Метод возвращает офис по id.
     */
    Office loadById(Long id);

    /**
     * Метод добавляет новую запись в таблицу "office".
     */
    void save(Office office);

    /**
     * Метод изменяет существующий офис.
     */
    void update(Office office);
}
