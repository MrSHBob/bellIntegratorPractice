package com.example.bellIntegrator.office.service;

import com.example.bellIntegrator.office.view.OfficeViewGet;
import com.example.bellIntegrator.office.view.OfficeViewListIn;
import com.example.bellIntegrator.office.view.OfficeViewListOut;
import com.example.bellIntegrator.office.view.OfficeViewSave;
import com.example.bellIntegrator.office.view.OfficeViewUpdate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import java.util.List;

/**
 * Интерфейс сервиса офиса.
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
    List<OfficeViewListOut> officeFilter(@Valid OfficeViewListIn view);

    /**
     * Возвращает офис по id.
     */
    OfficeViewGet officeById(Long id);
}
