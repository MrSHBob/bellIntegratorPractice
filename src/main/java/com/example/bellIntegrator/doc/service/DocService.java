package com.example.bellIntegrator.doc.service;

import com.example.bellIntegrator.doc.view.DocView;
import com.example.bellIntegrator.doc.view.DocViewSave;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

/**
 * Интерфейс сервиса, передающего запросы из контроллера в DAO для документа.
 */
@Validated
public interface DocService {

    /**
     * Добавление нового документа.
     */
    void add (@Valid DocViewSave doc);

    /**
     * Возвращение списка всех документов.
     */
    List<DocView> docs();
}
