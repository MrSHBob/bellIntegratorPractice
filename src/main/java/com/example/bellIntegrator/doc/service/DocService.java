package com.example.bellIntegrator.doc.service;

import com.example.bellIntegrator.doc.view.DocView;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface DocService {

    void add (@Valid DocView doc);

    List<DocView> docs();
}
