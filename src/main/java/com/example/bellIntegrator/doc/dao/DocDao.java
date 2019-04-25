package com.example.bellIntegrator.doc.dao;

import com.example.bellIntegrator.doc.model.Doc;

import java.util.List;

public interface DocDao {

    List<Doc> all();

    Doc loadById(Long id);

    void save(Doc doc);
}
