package com.example.bellIntegrator.dao.doc;

import com.example.bellIntegrator.model.Doc;

import java.util.List;

public interface DocDao {

    List<Doc> all();

    Doc loadById(Long id);

    void save(Doc doc);
}
