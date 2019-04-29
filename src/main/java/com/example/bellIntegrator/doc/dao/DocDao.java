package com.example.bellIntegrator.doc.dao;

import com.example.bellIntegrator.doc.model.Doc;

import java.util.List;

public interface DocDao {

    List<Doc> all();

    Doc loadById(Long id);

    Doc findByName(String name);

    Doc findByCode(Integer code);

    void save(Doc doc);
}
