package com.example.bellIntegrator.doc.dao;

import com.example.bellIntegrator.doc.model.Doc;

import java.util.List;

/**
 * Интерфейс DAO для документов.
 */
public interface DocDao {

    /**
     * Метод возвращает перечень документов.
     */
    List<Doc> all();

    /**
     * Метод возвращает документ по id.
     */
    Doc loadById(Long id);

    /**
     * Метод возвращает документ по имени.
     */
    Doc findByName(String name);

    /**
     * Метод возвращает документ по коду.
     */
    Doc findByCode(Integer code);

    /**
     * Метод добавляет новую запись в таблицу "docs".
     */
    void save(Doc doc);
}
