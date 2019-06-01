package com.example.bellIntegrator.organization.dao;

import com.example.bellIntegrator.organization.model.Organization;
import com.example.bellIntegrator.organization.view.OrganizationViewListIn;
import java.util.List;

/**
 * Интерфейс DAO для организации.
 */
public interface OrganizationDao {

    /**
     * Метод возвращает организацию по id.
     */
    Organization loadById(Long id);

    /**
     * Фильтр организаций по частичному вхождению по имени, и по ИНН.
     */
    List<Organization> organizationFilter(OrganizationViewListIn view);

    /**
     * Метод добавляет новую запись в таблицу "organization".
     */
    void save(Organization organization);

    /**
     * Изменение существующей организации.
     */
    void update(Organization organization);
}
