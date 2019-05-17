package com.example.bellIntegrator.office.service;

import com.example.bellIntegrator.office.view.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

/**
 * Интерфейс сервиса, передающего запросы из контроллера в DAO для офиса.
 */
@Validated
public interface OfficeService {

    /**
     * Добавление нового офиса.
     */
    void add (@Valid OfficeViewSave office);

    /**
     * Изменение офиса.
     */
    void update (@Valid OfficeViewUpdate view);

    /**
     * Фильтр офисов по организации и др. полям.
     */
    List<OfficeViewListOut> officeFilter(OfficeViewListIn view);

    /**
     * Возвращает офис по id.
     */
    OfficeViewGet officeById(Long id);
}
