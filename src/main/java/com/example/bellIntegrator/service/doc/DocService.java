package com.example.bellIntegrator.service.doc;

import com.example.bellIntegrator.view.DocView;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface DocService {

    void add (@Valid DocView doc);

    List<DocView> docs();
}
