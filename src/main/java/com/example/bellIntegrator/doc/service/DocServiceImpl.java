package com.example.bellIntegrator.doc.service;

import com.example.bellIntegrator.doc.dao.DocDao;
import com.example.bellIntegrator.doc.model.Doc;
import com.example.bellIntegrator.other.mapper.MapperFacade;
import com.example.bellIntegrator.doc.view.DocView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DocServiceImpl implements DocService {
    private final DocDao dao;
    private final MapperFacade mapperFacade;

    @Autowired
    public DocServiceImpl(DocDao dao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    @Transactional
    public void add(DocView view) {
        Doc doc = new Doc();
        doc.setCode(view.code);
        doc.setName(view.name);
        dao.save(doc);
    }

    @Override
    @Transactional
    public List<DocView> docs() {
        List<Doc> all = dao.all();
        return mapperFacade.mapAsList(all, DocView.class);
    }
}
