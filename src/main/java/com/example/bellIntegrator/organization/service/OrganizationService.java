package com.example.bellIntegrator.organization.service;

import com.example.bellIntegrator.organization.view.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

/**
 * Интерфейс сервиса, передающего запросы из контроллера в DAO для организации.
 */
@Validated
public interface OrganizationService {

    /**
     * Добавление новой организации.
     */
    void add (@Valid OrganizationViewSave organization);

    /**
     * Изменение организации.
     */
    void update (@Valid OrganizationViewUpdate view);

    /**
     * Фильтр организаций.
     */
    List<OrganizationViewListOut> organizationFilter(@Valid OrganizationViewListIn view);

    /**
     * Возвращает организацию по id.
     */
    OrganizationView organizationsById(Long id);
}
