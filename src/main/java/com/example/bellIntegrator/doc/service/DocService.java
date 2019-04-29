package com.example.bellIntegrator.doc.service;

import com.example.bellIntegrator.doc.view.DocView;
import com.example.bellIntegrator.doc.view.DocViewSave;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface DocService {

    void add (@Valid DocViewSave doc);

    List<DocView> docs();
}
